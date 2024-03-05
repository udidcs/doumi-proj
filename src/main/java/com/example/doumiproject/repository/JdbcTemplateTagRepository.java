package com.example.doumiproject.repository;

import com.example.doumiproject.responsedto.TagDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JdbcTemplateTagRepository implements TagRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTagRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<TagDto> findAll() {
        String sql="select type, GROUP_CONCAT(name ORDER BY id) as names, GROUP_CONCAT(id ORDER BY id) as ids "+
                "from tag "+
                "group by type";
        List<TagDto> tags = jdbcTemplate.query(sql, TagRowMapper());

        List<String> order= Arrays.asList("Java", "Spring", "DB", "AWS", "FrontEnd");
        //order로 정의한 순으로 정렬
        tags.sort(Comparator.comparingInt(tagDto->order.indexOf(tagDto.getType())));
        return tags;
    }

}
