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
    private TaskRepository mTaskRepository;
    private UserService mUserService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        mTaskRepository = taskRepository;
        mUserService = userService;
    }


    public List<TaskEntity> getAllUsersTasks(String username) {
        Long userId = mUserService.getIdByUsername(username);

        List<TaskEntity> taskEntities = Lists.newArrayList(mTaskRepository.findAll());

        List<TaskEntity> usersTaskEntities = new ArrayList<>();

        for (TaskEntity taskEntity : taskEntities) {
            if (taskEntity.getUserId().equals(userId)) usersTaskEntities.add(taskEntity);
        }
        return usersTaskEntities;
    }
}
