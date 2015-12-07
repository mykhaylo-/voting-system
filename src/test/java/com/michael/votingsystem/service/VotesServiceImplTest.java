package com.michael.votingsystem.service;

import com.michael.votingsystem.model.Restaurant;
import com.michael.votingsystem.model.User;
import com.michael.votingsystem.model.Vote;
import com.michael.votingsystem.repository.RestaurantRepository;
import com.michael.votingsystem.repository.UserRepository;
import com.michael.votingsystem.repository.VoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VotesServiceImplTest {

    @InjectMocks
    private VotesService unit = new VotesServiceImpl();

    @Mock
    private UserRepository userRepository;

    @Mock
    private VoteRepository voteRepository;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Test
    public void testVoteWhenUserHaventVotedYet() throws Exception {
        // Given
        User user = new User();
        user.setUsername("michael");

        when(userRepository.findByUsername(anyString())).thenReturn(user);
        when(voteRepository.findByUser(any(User.class))).thenReturn(Optional.empty());

        Restaurant restaurant = new Restaurant();
        restaurant.setName("sample restaurant");
        when(restaurantRepository.findOne(anyLong())).thenReturn(restaurant);

        // When
        unit.vote("michael", 4L);

        // Then
        verify(userRepository).findByUsername("michael");
        verify(voteRepository).findByUser(user);
        verify(restaurantRepository).findOne(4L);

        Vote vote = new Vote();
        vote.setRestaurant(restaurant);
        vote.setUser(user);

        verify(voteRepository).save(vote);
    }

// TODO add two tests with expected VotingCLosedException and without
// 1st mock time to be before 11 AM and 2nd - mock time to be after 11 AM
    @Test
    public void testVoteWhenVotingAlreadyForbidden() throws Exception {
        // TODO :
    }

    @Test
    public void testVoteWhenUpdatingVoteIsAllowed() throws Exception {
        // TODO :
    }

}