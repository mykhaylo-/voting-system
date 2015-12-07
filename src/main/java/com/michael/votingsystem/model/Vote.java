package com.michael.votingsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","restaurant_id"}))
@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
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

    @Override
    public int hashCode() {
        return Objects.hash(id, user, restaurant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(id, vote.id) &&
                Objects.equals(user, vote.user) &&
                Objects.equals(restaurant, vote.restaurant);
    }
}
