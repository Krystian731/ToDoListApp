package com.andrzejewski.todolist.user;

import com.andrzejewski.todolist.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository mUserRepository;

    public UserService(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() { return mUserRepository.findAll(); }

    public UserEntity getById(Long id) {
        return mUserRepository
                .findById(id)
                .orElseThrow(() -> new UserDoesNotExistException(id));
    }

    public boolean checkUsername(String username) {
        return mUserRepository.findUserByUsername(username);
    }

    public boolean signUpUsername(String username) {
        if (!mUserRepository.findUserByUsername(username)) { addNewUser(username); return true; }

        return false;
    }

    public void addNewUser(String username) { mUserRepository.save(new UserEntity(username)); }
}
