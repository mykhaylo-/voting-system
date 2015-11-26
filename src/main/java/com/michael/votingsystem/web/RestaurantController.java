package com.michael.votingsystem.web;

import com.michael.votingsystem.facade.VotesFacade;
import com.michael.votingsystem.model.Menu;
import com.michael.votingsystem.model.Restaurant;
import com.michael.votingsystem.service.RestaurantService;
import com.michael.votingsystem.service.VotesService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Resource
    private RestaurantService restaurantService;

    @Resource
    private VotesFacade votesFacade;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Restaurant> restaurants() {
        return restaurantService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Restaurant restaurant(@PathVariable long id) {
        return restaurantService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    @RequestMapping(value = "/{id}/menu", method = RequestMethod.PUT)
    public void defineMenu(@PathVariable Long id, Menu menu) {
        restaurantService.updateMenu(id, menu);
    }

    @RequestMapping(value = "/{id}/vote", method = RequestMethod.POST)
    public void vote(@PathVariable long id, @AuthenticationPrincipal UserDetails user) {
        votesFacade.vote(id, user.getUsername());
    }
}
