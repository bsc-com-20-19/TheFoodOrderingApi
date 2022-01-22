package com.example.demo.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }
    public void addNewRestaurant(Restaurant restaurant){
        Optional<Restaurant> restaurantOptional = restaurantRepository
                .findRestaurantById(restaurant.getRestaurantId());
        if (restaurantOptional.isPresent()){
            throw new IllegalStateException("RestaurantId taken");
        }
        restaurantRepository.save(restaurant);
    }
    public void deleteRestaurant(Long restaurantId){
        boolean exists = restaurantRepository.existsById(restaurantId);
        if (!exists) {
            throw new IllegalStateException(
                    "Restaurant with id " + restaurantId + " does not exists");
        }
        restaurantRepository.deleteById(restaurantId);
    }

    @Transactional
    public void updateRestaurant(Long restaurantId,
                                 String name,
                               String location
                               ){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalStateException(
                        "Restaurant with id " + restaurantId + " does not exist"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(restaurant.getName(), name)){
            restaurant.setName(name);
        }
        restaurant.setLocation(location);
    }
}