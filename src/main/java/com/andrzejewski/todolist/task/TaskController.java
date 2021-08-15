package com.andrzejewski.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    @Autowired
    private TaskService mTaskService;

    @GetMapping("/{userId}")
    public List<TaskEntity> getAllTasksByUserId(@PathVariable("userId") Long userId, @RequestParam(required = false) boolean completedTask) {
        return mTaskService.getAllTasksByUserId(userId, completedTask);
    }

    @PostMapping
    public void addNewTask(@RequestBody TaskEntity taskEntity) {
        mTaskService.addNewTask(taskEntity);
    }

    @DeleteMapping("/{userId}/{taskId}")
    public boolean deleteTaskById(@PathVariable Long userId, @PathVariable Long taskId) {
        return mTaskService.deleteTask(userId, taskId);
    }

    @PatchMapping("/{taskId}/updateText")
    public void updateTask(@PathVariable Long taskId, @RequestParam String text) {
        mTaskService.updateTaskText(taskId, text);
    }

    @PatchMapping("/{taskId}/taskCompleted")
    public void markTaskAsDone(@PathVariable Long taskId, @RequestParam String taskCompletionDate) {
        mTaskService.markTaskAsDone(taskId, taskCompletionDate);
    }
}
