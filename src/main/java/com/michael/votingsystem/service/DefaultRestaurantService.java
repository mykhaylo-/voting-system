package com.michael.votingsystem.service;

import com.michael.votingsystem.model.Menu;
import com.michael.votingsystem.model.Restaurant;
import com.michael.votingsystem.repository.RestaurantRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DefaultRestaurantService implements RestaurantService {

    @Resource
    private RestaurantRepository restaurantRepository;

    @Override
    public Iterable<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getById(Long id) {
        return restaurantRepository.findOne(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateMenu(Long id, Menu menu) {
        Restaurant restaurant = restaurantRepository.findOne(id);
        restaurant.setLunchMenu(menu);
        return restaurantRepository.save(restaurant);
    }
}
