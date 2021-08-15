package com.andrzejewski.todolist.task;

import com.andrzejewski.todolist.exceptions.TaskDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class TaskService {

    @Autowired
    private TaskRepository mTaskRepository;

    public List<TaskEntity> getAllTasksByUserId(Long userId, boolean completedTask) {
        if (completedTask) return mTaskRepository.findAllCompletedTasksByUserId(userId);

        return mTaskRepository.findAllNotCompletedTasksByUserId(userId);
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
    public void updateTaskText(Long id, String text) {
        TaskEntity taskEntity = mTaskRepository.findById(id).orElseThrow(() -> new TaskDoesNotExistException(id));
        taskEntity.setTaskText(text);
    }

    @Transactional
    public void markTaskAsDone(Long id, String taskCompletionDate) {
        TaskEntity taskEntity = mTaskRepository.findById(id).orElseThrow(() -> new TaskDoesNotExistException(id));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
        taskEntity.setTaskCompletionDate(LocalDateTime.parse(taskCompletionDate));
    }
}
