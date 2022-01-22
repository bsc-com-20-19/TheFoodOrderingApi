package com.example.demo.restaurant;


import javax.persistence.*;
@Entity
@Table
public class Restaurant {
    @Id
    @SequenceGenerator(
            name = "restaurant_sequence",
            sequenceName = "restaurant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "restaurant_sequence"
    )

    private String name;
    private String location;
    private Long restaurantId;

    public Restaurant() {
    }

    public Restaurant(String name, String location, Long restaurantId) {
        this.name = name;
        this.location = location;
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", restaurantId=" + restaurantId +
                '}';
    }
}
