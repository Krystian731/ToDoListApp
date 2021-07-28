package com.andrzejewski.todolist.user;

import com.andrzejewski.todolist.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.assertj.core.util.Lists;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository mUserRepository;

    public UserService(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() { return Lists.newArrayList(mUserRepository.findAll()); }

    public UserEntity getById(Long id) {
        return mUserRepository
                .findById(id)
                .orElseThrow(() -> new UserDoesNotExistException(id));
    }

    public boolean checkUsername(String username) {
        List<UserEntity> userEntities = Lists.newArrayList(mUserRepository.findAll());

        for (UserEntity userEntity : userEntities) {
            if (userEntity.getUsername().equals(username)) return true;
        }

        return false;
    }

    public Long getIdByUsername(String username) {
        List<UserEntity> userEntities = Lists.newArrayList(mUserRepository.findAll());

        for (UserEntity userEntity : userEntities) {
            if (userEntity.getUsername().equals(username)) return userEntity.getUserId();
        }
        throw new UserDoesNotExistException(username);
    }

    public void addNewUser(String username) {
        mUserRepository.save(new UserEntity(username));
    }
}
