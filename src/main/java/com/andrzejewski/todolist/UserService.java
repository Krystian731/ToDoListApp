package com.andrzejewski.todolist;

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
}
