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

        Optional<TaskEntity> task = mTaskRepository.findById(taskId);
        if(!task.isPresent() || !task.get().getUserId().equals(userId)) return false;
        mTaskRepository.deleteById(taskId);
        return true;
    }
}
