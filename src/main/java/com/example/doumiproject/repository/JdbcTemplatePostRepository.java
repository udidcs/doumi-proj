package com.example.doumiproject.repository;

import com.example.doumiproject.dto.PostDto;
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
    public List<PostDto> findAllQuiz(int page, int pageSize) {

        int offset = (page - 1) * pageSize;

        String sql = "select p.id," +
                "u.userId as author," +
                "p.type, p.title, p.contents, p.created_at," +
                "p.updated_at, p.like as like_count " +
                "from post p " +
                "inner join " +
                "user u on p.user_id = u.id " +
                "order by " +
                "p.id desc " +
                "limit ? offset ?";

        return jdbcTemplate.query(sql, postDtoRowMapper(), pageSize, offset);
    }

    @Override
    public List<PostDto> findAllQuiz() {

        String sql = "select p.id," +
                "u.userId as author," +
                "p.type, p.title, p.contents, p.created_at," +
                "p.updated_at, p.like as like_count " +
                "from post p " +
                "inner join " +
                "user u on p.user_id = u.id " +
                "order by " +
                "p.id desc ";

        return jdbcTemplate.query(sql, postDtoRowMapper());
    }

    @Override
    public int getTotalPages(int pageSize) {

        String sql = "select ceil(count(*) / ?) as totalPages " +
                "from post";

        return jdbcTemplate.queryForObject(sql, Integer.class, pageSize);
    }

    @Override
    public List<PostDto> findByTitleOrAuthor(String keyword, int page, int pageSize) {

        String param = "%"+keyword+"%";
        int offset = (page - 1) * pageSize;

        String sql = "select p.id," +
                "u.userId as author," +
                "p.type, p.title, p.contents, p.created_at," +
                "p.updated_at, p.like as like_count " +
                "from post p " +
                "inner join " +
                "user u on p.user_id = u.id " +
                "where p.title like ? " +
                "or u.userId like ? " +
                "order by " +
                "p.id desc "+
                "limit ? offset ?";

        return jdbcTemplate.query(sql, postDtoRowMapper(), param, param, pageSize, offset);
    }

    @Override
    public int getTotalPages(int pageSize, String keyword) {

        String param = "%"+keyword+"%";

        String sql = "select ceil(count(*) / ?) " +
                "from post p " +
                "inner join " +
                "user u on p.user_id = u.id " +
                "where p.title like ? " +
                "or u.userId like ? ";

        return jdbcTemplate.queryForObject(sql, Integer.class, pageSize, param, param);
    }
}
