package com.andrzejewski.todolist.exceptions;

import java.io.IOException;

public class WrongRedirectException extends IOException{
    public WrongRedirectException() { super("Wrong redirect"); }
}
