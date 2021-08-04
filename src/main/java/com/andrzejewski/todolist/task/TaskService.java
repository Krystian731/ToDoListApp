package com.andrzejewski.todolist.task;

import com.andrzejewski.todolist.user.UserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository mTaskRepository;
    private final UserService mUserService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        mTaskRepository = taskRepository;
        mUserService = userService;
    }

    public List<TaskEntity> getAllTasksByUsername(String username) {
        Long userId = mUserService.getIdByUsername(username);

        List<TaskEntity> taskEntities = Lists.newArrayList(mTaskRepository.findAll());

        List<TaskEntity> usersTaskEntities = new ArrayList<>();

        for (TaskEntity taskEntity : taskEntities) {
            if (taskEntity.getUserId().equals(userId)) usersTaskEntities.add(taskEntity);
        }
        return usersTaskEntities;
    }

    public void addNewTask(TaskEntity taskEntity) {
        mTaskRepository.save(taskEntity);
    }

    public boolean deleteTask(String username, Long taskId) {

        Long userId = mUserService.getIdByUsername(username);
        if (mTaskRepository.findById(taskId).get().getUserId().equals(userId)) { mTaskRepository.deleteById(taskId); return true;}

        return false;
    }
}
