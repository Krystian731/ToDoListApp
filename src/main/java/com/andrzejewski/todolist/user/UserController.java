package com.andrzejewski.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService mUserService;

    @GetMapping(path = "/users")
    public List<UserEntity> getAllUsers() { return mUserService.getAllUsers();}

    @GetMapping(path = "/users/{userId}")
    public UserEntity getUserById(@PathVariable("userId") Long id) { return mUserService.getById(id);}

    @GetMapping("/login/{username}")
    public boolean isValidLoginUsername(@PathVariable("username") String username) {
        return mUserService.checkUsername(username);
    }

    @PostMapping
    public boolean isValidSignUpUsername(@RequestBody UserEntity userEntity) {
        return mUserService.signUpUsername(userEntity);
    }
}
