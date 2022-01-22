package com.example.demo.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @GetMapping
    public List<Restaurant> getRestaurants(){

        return restaurantService.getRestaurants();
    }

    @PostMapping
    public void registerNewRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addNewRestaurant(restaurant);

    }
    @DeleteMapping(path = "{restaurantId}")
    public void deleteRestaurant(
            @PathVariable("restaurantId") Long restaurantId){
        restaurantService.deleteRestaurant(restaurantId);
    }

    @PutMapping(path = "{restaurantId}")
    public void updateRestaurant(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location){
        restaurantService.updateRestaurant(restaurantId, name, location);
    }
}