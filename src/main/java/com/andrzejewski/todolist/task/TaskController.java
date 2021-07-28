package com.andrzejewski.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService mTaskService;

    public TaskController(TaskService taskService) {
        mTaskService = taskService;
    }

    @GetMapping("/users/{username}")
    public List<TaskEntity> getAllUsersTasks(@PathVariable("username") String username) {
        return mTaskService.getAllUsersTasks(username);
    }


}
