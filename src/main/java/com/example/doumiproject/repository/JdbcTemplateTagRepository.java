package com.example.doumiproject.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JdbcTemplateTagRepository implements TagRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTagRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    @Override
    public List<String> getByQuizId(long id) {
        String sql = "select t.name "+
                "from tag t inner join quiztag qt on t.id = qt.tag_id "+
                "where qt.post_id = ?";
        return jdbcTemplate.query(sql, tagRowMapper(), id);
    }

}
