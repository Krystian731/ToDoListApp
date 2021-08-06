package com.andrzejewski.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class TaskController {

    @Autowired
    private TaskService mTaskService;

    @GetMapping("/{userId}")
    public List<TaskEntity> getAllTasksByUserId(@PathVariable("userId") Long userId) {
        return mTaskService.getAllTasksByUserId(userId);
    }

    @PostMapping
    public void addNewTask(@RequestBody TaskEntity taskEntity) {
        mTaskService.addNewTask(taskEntity);
    }

    @DeleteMapping("/{userId}/{taskId}")
    public boolean deleteTaskById(@PathVariable Long userId, @PathVariable Long taskId) {
        return mTaskService.deleteTask(userId, taskId);
    }
}
