package com.example.doumiproject.repository;

import com.example.doumiproject.entity.User;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateUserRepository implements UserRepository {

    //Spring에서 JdbcTemplate를 사용하면 JDBC를 편리하게 사용할 수 있다
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User selectUserById(int id) {

        String sql = "select id, user_id, user_password, role from user where id = ?";

        return jdbcTemplate.queryForObject(sql, userRowMapper(), id);
    }



}
