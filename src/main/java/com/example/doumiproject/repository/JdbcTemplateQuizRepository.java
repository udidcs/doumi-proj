package com.example.doumiproject.repository;

import com.example.doumiproject.dto.QuizDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcTemplateQuizRepository implements QuizRepository {
    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateQuizRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public QuizDto getByQuizId(long id) {
        String sql = "select p.id as post_id, p.user_id, p.title, p.contents, p.created_at, p.like, a.answer, " +
                "u.nickname " +
                "from post p " +
                "inner join answer a on p.id = a.post_id " +
                "inner join user u on p.user_id = u.id " +
                "where p.id = ?";
        return jdbcTemplate.queryForObject(sql,quizDtoRowMapper(), id);
    }
}