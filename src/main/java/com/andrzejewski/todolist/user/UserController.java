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
    public boolean isValidUsernameForLogin(@PathVariable("username") String username) {
        return mUserService.isUsernameTaken(username);
    }

    @PostMapping("/users/{save}")
    public boolean signUpUsername(@RequestBody UserEntity userEntity) {
        return mUserService.signUpUsername(userEntity);
    }
}
