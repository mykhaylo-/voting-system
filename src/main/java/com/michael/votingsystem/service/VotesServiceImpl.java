package com.michael.votingsystem.service;

import com.michael.votingsystem.model.Restaurant;
import com.michael.votingsystem.model.User;
import com.michael.votingsystem.model.Vote;
import com.michael.votingsystem.repository.VoteRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VotesServiceImpl implements VotesService{

    @Resource
    private VoteRepository voteRepository;

    @Override
    public void vote(User user, Restaurant restaurant) {
        Vote vote = voteRepository.findByUser(user);

    }
}
