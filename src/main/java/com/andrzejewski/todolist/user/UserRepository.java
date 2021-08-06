package com.andrzejewski.todolist.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();

    default boolean findUserByUsername(String username) {
        List<UserEntity> userEntities = findAll();

        for (UserEntity userEntity : userEntities) {
            if (userEntity.getUsername().equals(username)) return true;
        }

        return false;
    }
}
