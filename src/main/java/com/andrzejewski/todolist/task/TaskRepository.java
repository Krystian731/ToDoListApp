package com.andrzejewski.todolist.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    List<TaskEntity> findAll();

    default List<TaskEntity> findAllTasksByUserId(Long userId) {
        List<TaskEntity> taskEntities = findAll();

        List<TaskEntity> usersTaskEntities = new ArrayList<>();

        for (TaskEntity taskEntity : taskEntities) {
            if (taskEntity.getUserId().equals(userId)) usersTaskEntities.add(taskEntity);
        }
        return usersTaskEntities;
    }
}
