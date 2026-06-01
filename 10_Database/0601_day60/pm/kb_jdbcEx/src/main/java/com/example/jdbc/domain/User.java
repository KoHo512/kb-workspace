package com.example.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class User {
    private String userId;
    private String username;
    private String userPassword;
    private int userAge;
    private String userEmail;

    public User() {
    }

    public User(String userId, String username, String userPassword, int userAge, String userEmail) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
        this.userAge = userAge;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getUserAge() {
        return userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
