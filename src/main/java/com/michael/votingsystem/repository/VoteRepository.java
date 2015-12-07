package com.michael.votingsystem.repository;

import com.michael.votingsystem.model.User;
import com.michael.votingsystem.model.Vote;
import org.jboss.logging.annotations.Param;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VoteRepository extends CrudRepository<Vote, Long>{

    Optional<Vote> findByUser(User user);
}
