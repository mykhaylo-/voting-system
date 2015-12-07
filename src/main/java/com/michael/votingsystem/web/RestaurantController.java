package com.michael.votingsystem.web;

import com.michael.votingsystem.model.Menu;
import com.michael.votingsystem.model.Restaurant;
import com.michael.votingsystem.service.RestaurantService;
import com.michael.votingsystem.service.VotesService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Resource
    private RestaurantService restaurantService;

    @Resource
    private VotesService votesService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Restaurant> restaurants() {
        return restaurantService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Restaurant restaurant(@PathVariable long id) {
        return restaurantService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant createRestaurant( @RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    @RequestMapping(value = "/{id}/menu", method = RequestMethod.PUT)
    public void defineMenu(@PathVariable Long id, @RequestBody Menu menu) {
        restaurantService.updateMenu(id, menu);
    }

    @RequestMapping(value = "/{id}/vote", method = RequestMethod.POST)
    public void vote(@PathVariable long id, @AuthenticationPrincipal User user) {
        votesService.vote(user.getUsername(), id);
    }
}
