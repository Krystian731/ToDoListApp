package com.andrzejewski.todolist;

public class StringDoesNotExistException extends RuntimeException {
    public StringDoesNotExistException(Long id) {
        super("There is no string with id " + id);
    }
}
