package com.michael.votingsystem.repository;

import com.michael.votingsystem.model.User;
import com.michael.votingsystem.model.Vote;
import org.jboss.logging.annotations.Param;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long>{

    Vote findByUser(User user);
}
