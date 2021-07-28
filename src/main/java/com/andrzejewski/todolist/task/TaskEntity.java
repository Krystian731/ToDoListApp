package com.andrzejewski.todolist.task;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "task_id")
    private Long mTaskId;

    @Column(name = "user_id")
    private Long mUserId;

    @Column(name = "task_text")
    private String mTaskText;

    @Column(name = "task_completion")
    private boolean mTaskCompletion;

    public Long getTaskId() {
        return mTaskId;
    }

    public void setTaskId(Long taskId) {
        mTaskId = taskId;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public String getTaskText() {
        return mTaskText;
    }

    public void setTaskText(String taskText) {
        mTaskText = taskText;
    }

    public boolean isTaskCompletion() {
        return mTaskCompletion;
    }

    public void setTaskCompletion(boolean taskCompletion) {
        mTaskCompletion = taskCompletion;
    }
}
