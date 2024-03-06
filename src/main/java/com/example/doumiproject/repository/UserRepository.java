package com.example.doumiproject.repository;

import com.example.doumiproject.entity.CoteBoard;
import com.example.doumiproject.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface UserRepository {

    public User selectUserById(int user);

    default RowMapper<User> userRowMapper() {
        return ((rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserId(rs.getString("user_id"));
            user.setUserPassword(rs.getString("user_password"));
            user.setRole(rs.getString("role"));
            return user;
        });
    }
}
