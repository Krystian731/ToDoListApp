package com.andrzejewski.todolist.task;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    List<TaskEntity> findAll();

    @Query(value = "SELECT * FROM TASKS WHERE user_id = :userId", nativeQuery = true)
    List<TaskEntity> findAllTasksByUserId(Long userId);

}
