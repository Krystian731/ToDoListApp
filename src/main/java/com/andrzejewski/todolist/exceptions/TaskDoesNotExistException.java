package com.andrzejewski.todolist.exceptions;

import java.io.IOException;

public class TaskDoesNotExistException extends RuntimeException {
    public TaskDoesNotExistException(Long id) { super("Task with id " + id + " does not exist!"); }
}