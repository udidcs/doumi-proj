package com.example.doumiproject.entity;

import lombok.*;

@Data
public class User {

    private long id;
    private String userId;
    private String userPassword;
    private String role;
}
