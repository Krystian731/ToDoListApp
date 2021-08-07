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
        return mUserRepository.findUserByUsername(username) != null;
    }

    public boolean signUpUsername(UserEntity userEntity) {
        if (mUserRepository.findUserByUsername(userEntity.getUsername()) == null) { addNewUser(userEntity); return true; }

        return false;
    }

    public void addNewUser(UserEntity userEntity) { mUserRepository.save(userEntity); }
}
