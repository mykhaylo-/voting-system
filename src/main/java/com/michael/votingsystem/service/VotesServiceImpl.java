package com.michael.votingsystem.service;

import com.michael.votingsystem.model.User;
import com.michael.votingsystem.model.Vote;
import com.michael.votingsystem.repository.RestaurantRepository;
import com.michael.votingsystem.repository.UserRepository;
import com.michael.votingsystem.repository.VoteRepository;
import com.michael.votingsystem.service.exception.VotingClosedException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Clock;
import java.util.Calendar;
import java.util.Optional;

@Service
public class VotesServiceImpl implements VotesService {

    @Resource
    private VoteRepository voteRepository;

    @Resource
    private RestaurantRepository restaurantRepository;

    @Resource
    private UserRepository userRepository;

    @Override
    public void vote(String username, Long restaurantId) {
        User user = userRepository.findByUsername(username);
        Optional<Vote> vote = voteRepository.findByUser(user);

        if (vote.isPresent()) {
            if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 10) {
                throw new VotingClosedException("Sorry, you cannot change your vote.");
            }
            vote.get().setRestaurant(restaurantRepository.findOne(restaurantId));
            voteRepository.save(vote.get());
        } else {
            Vote newVote = new Vote();
            newVote.setRestaurant(restaurantRepository.findOne(restaurantId));
            newVote.setUser(user);
            voteRepository.save(newVote);
        }
    }
}
