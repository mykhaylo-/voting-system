package com.michael.votingsystem.facade;

import com.michael.votingsystem.model.Restaurant;
import com.michael.votingsystem.model.User;
import com.michael.votingsystem.repository.UserRepository;
import com.michael.votingsystem.service.RestaurantService;
import com.michael.votingsystem.service.VotesService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class VotesFacadeImpl implements  VotesFacade{

    @Resource
    private UserRepository userRepository;

    @Resource
    private RestaurantService restaurantService;

    @Resource
    private VotesService votesService;

    @Override
    public void vote(Long restaurantId, String username) {
        User user = userRepository.findByUsername(username);
        Restaurant restaurant = restaurantService.getById(restaurantId);

        votesService.vote(user, restaurant);
    }
}
