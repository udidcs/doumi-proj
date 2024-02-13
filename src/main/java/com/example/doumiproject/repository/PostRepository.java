package com.example.doumiproject.repository;

import com.example.doumiproject.dto.PostDto;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface PostRepository {

    public List<PostDto> findAllPost();

    default RowMapper<PostDto> postDtoRowMapper() {
        return ((rs, rowNum) -> {
            PostDto postDto = new PostDto();
            postDto.setId(rs.getLong("id"));
            postDto.setUserId(rs.getString("author"));
            postDto.setTitle(rs.getString("title"));
            postDto.setContents(rs.getString("contents"));

            return postDto;
        });
    };
}
