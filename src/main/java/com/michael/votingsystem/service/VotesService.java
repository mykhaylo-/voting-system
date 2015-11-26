package com.michael.votingsystem.service;

import com.michael.votingsystem.model.Restaurant;
import com.michael.votingsystem.model.User;

public interface VotesService {

    void vote(User user, Restaurant restaurant);
}
