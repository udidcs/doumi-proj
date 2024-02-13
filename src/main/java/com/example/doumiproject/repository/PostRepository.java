package com.example.doumiproject.repository;

import com.example.doumiproject.vo.PostVO;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface PostRepository {

    public List<PostVO> findAllPost();

    default RowMapper<PostVO> postRowMapper() {
        return ((rs, rowNum) -> {
            PostVO post = new PostVO();
            post.setId(rs.getLong("id"));
            post.setUserId(rs.getLong("user_id"));
            post.setTitle(rs.getString("title"));
            post.setContents(rs.getString("contents"));

            return post;
        });
    };
}
