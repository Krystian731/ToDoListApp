package com.andrzejewski.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserService mUserService;

    public UserController(UserService userService) {
        mUserService = userService;
    }

    @GetMapping(path = "/all")
    public List<UserEntity> getAllUsers() { return mUserService.getAllUsers();}

    @GetMapping(path = "/get/{userId}")
    public UserEntity getUserById(@PathVariable("userId") Long id) { return mUserService.getById(id);}
}
