package com.andrzejewski.todolist.task;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    List<TaskEntity> findAll();

    @Query(value = "SELECT * FROM tasks WHERE user_id = :userId AND task_completion_date IS NULL", nativeQuery = true)
    List<TaskEntity> findAllNotCompletedTasksByUserId(Long userId);

    @Query(value = "SELECT * FROM tasks WHERE user_id = :userId AND task_completion_date IS NOT NULL", nativeQuery = true)
    List<TaskEntity> findAllCompletedTasksByUserId(Long userId);


}
