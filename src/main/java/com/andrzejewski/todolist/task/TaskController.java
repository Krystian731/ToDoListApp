package com.andrzejewski.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/users")
public class TaskController {

    @Autowired
    private TaskService mTaskService;

    public TaskController(TaskService taskService) {
        mTaskService = taskService;
    }

    @GetMapping("/{username}")
    public List<TaskEntity> getAllTasksByUsername(@PathVariable("username") String username) {
        return mTaskService.getAllTasksByUsername(username);
    }

    @PostMapping()
    public void addNewTask(@RequestBody TaskEntity taskEntity) {
        mTaskService.addNewTask(taskEntity);
    }

    @DeleteMapping("/{username}/{taskId}")
    public boolean deleteTaskById(@PathVariable String username, @PathVariable Long taskId) {
        return mTaskService.deleteTask(username, taskId);
    }
}
