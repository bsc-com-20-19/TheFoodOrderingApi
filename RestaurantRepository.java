package com.example.demo.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT s FROM Restaurant s WHERE s.restaurantId = ?1")
    Optional<Restaurant> findRestaurantById(Long restaurantId);
}
