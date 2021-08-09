package com.andrzejewski.todolist.task;

import com.andrzejewski.todolist.exceptions.TaskDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    @Transactional
    public void updateTask(Long id, String text, LocalDate date) {
        TaskEntity taskEntity = mTaskRepository.findById(id).orElseThrow(() -> new TaskDoesNotExistException(id));
        if (text != null) { taskEntity.setTaskText(text); }
        taskEntity.setTaskCompletionDate(date);
    }
}
