package com.michael.votingsystem.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class VotingClosedException extends RuntimeException {

    public VotingClosedException(String message) {
        super(message);
    }
}
