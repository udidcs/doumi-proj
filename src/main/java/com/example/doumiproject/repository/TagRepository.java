package com.example.doumiproject.repository;


import org.springframework.jdbc.core.RowMapper;
import java.util.List;

public interface TagRepository {
    List<String> getByQuizId(long id);

    default RowMapper<String> tagRowMapper() {
        return (rs,rowNum)->{
          String tagName=rs.getString("name");
          return tagName;
        };
    }
}
