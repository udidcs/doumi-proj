package com.example.doumiproject.repository;

import com.example.doumiproject.vo.PostVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcTemplatePostRepository implements PostRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplatePostRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<PostVO> findAllPost() {

        return jdbcTemplate.query("select * from post", postRowMapper());
    }
}
