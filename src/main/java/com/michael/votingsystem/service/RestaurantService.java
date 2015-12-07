package com.michael.votingsystem.service;

import com.michael.votingsystem.model.Menu;
import com.michael.votingsystem.model.Restaurant;
import org.springframework.security.core.userdetails.User;

public interface RestaurantService {

    Iterable<Restaurant> getAll();

    Restaurant getById(Long id);

    Restaurant save(Restaurant restaurant);

    void updateMenu(Long id, Menu menu);
}
