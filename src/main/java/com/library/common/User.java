package com.library.common;

import java.io.Serializable;

public class User implements Serializable {

    private String userFirstName;
    private String userLastName;
    private Integer userId;

    public User(String userName, String userLastName, Integer userId) {
        this.userFirstName = userName;
        this.userLastName = userLastName;
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User: " + userFirstName + ", " + userLastName + ", Id: " + userId;
    }
}

