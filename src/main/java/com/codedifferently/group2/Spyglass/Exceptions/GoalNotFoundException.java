package com.codedifferently.group2.Spyglass.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * GoalNotFoundException is a custom exception that indicates an issue with finding a desired goal
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GoalNotFoundException extends RuntimeException {
    public GoalNotFoundException(Long id) {
        super("Could not find goal" + id);
    }
}
