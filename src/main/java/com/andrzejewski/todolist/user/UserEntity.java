package com.andrzejewski.todolist.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id")
    private Long mUserId;

    @Column(name = "username")
    private String mUsername;

    public UserEntity() {
    }

    public UserEntity(String username) {
        mUsername = username;
    }

    public Long getUserId() { return mUserId; }

    public void setUserId(Long userId) {
        this.mUserId = userId;
    }

    public String getUsername() { return mUsername; }

    public void setUsername(String username) {
        this.mUsername = username;
    }

}
