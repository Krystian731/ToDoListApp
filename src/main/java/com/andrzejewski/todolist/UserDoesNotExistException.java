package com.andrzejewski.todolist;

public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException(Long id) {
        super("There is no user with id " + id);
    }
}
