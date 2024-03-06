package com.example.doumiproject.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {

    private String userId;
    private String userPassword;
    private String role;
}
