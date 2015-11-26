package com.michael.votingsystem.model;

import javax.persistence.*;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user","restaurant"}))
@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Long id;
    private User user;

    private Restaurant restaurant;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
