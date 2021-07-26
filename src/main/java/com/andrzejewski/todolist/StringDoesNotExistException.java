package com.andrzejewski.todolist;

public class StringDoesNotExistException extends IllegalStateException {
    public StringDoesNotExistException(Long id) {
        super("There is no string with id " + id);
    }
}
