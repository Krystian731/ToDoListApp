package com.andrzejewski.todolist.user;

import com.andrzejewski.todolist.exceptions.WrongRedirectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService mUserService;

    public UserController(UserService userService) {
        mUserService = userService;
    }

    @GetMapping(path = "/users/all")
    public List<UserEntity> getAllUsers() { return mUserService.getAllUsers();}

    @GetMapping(path = "/users/get/{userId}")
    public UserEntity getUserById(@PathVariable("userId") Long id) { return mUserService.getById(id);}

    @GetMapping("/")
    public void redirect(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/login");
    }

    @GetMapping("/login/{username}")
    public boolean isValidLoginUsername(@PathVariable("username") String username, HttpServletResponse httpServletResponse) throws IOException {
        if (!mUserService.checkUsername(username)) return false;

        System.out.println(username);
        httpServletResponse.sendRedirect("/users/" + username);
        return true;
    }

    @GetMapping("/signUp/{username}")
    public boolean isValidSignUpUsername(@PathVariable("username") String username, HttpServletResponse httpServletResponse) throws IOException {
        if (mUserService.checkUsername(username)) return false;

        mUserService.addNewUser(username);

        httpServletResponse.sendRedirect("/users/" + username);

        return true;
    }
}
