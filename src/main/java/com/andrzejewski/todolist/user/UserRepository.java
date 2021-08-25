package com.andrzejewski.todolist.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();

    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    UserEntity findUserByUsername(String username);
}
