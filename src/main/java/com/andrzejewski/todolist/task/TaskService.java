package com.andrzejewski.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    @Autowired
    private TaskRepository mTaskRepository;

    public List<TaskEntity> getAllTasksByUserId(Long userId) {
        return mTaskRepository.findAllTasksByUserId(userId);
    }

    public void addNewTask(TaskEntity taskEntity) {
        mTaskRepository.save(taskEntity);
    }

    public boolean deleteTask(Long userId, Long taskId) {

        if (mTaskRepository.existsById(taskId) && mTaskRepository.findById(taskId).get()
                        .getUserId()
                .equals(userId)) { mTaskRepository.deleteById(taskId); return true;}

        return false;
    }
}
