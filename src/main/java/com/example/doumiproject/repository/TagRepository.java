package com.example.doumiproject.repository;


import com.example.doumiproject.dto.TagDetailDto;
import com.example.doumiproject.dto.TagDto;
import org.springframework.jdbc.core.RowMapper;

import java.util.*;

public interface TagRepository {
    List<String> getByQuizId(long id);
    List<TagDto> findAll();

    default RowMapper<String> QuizDetailTagRowMapper() {
        return (rs,rowNum)->{
          String tagName=rs.getString("name");
          return tagName;
        };
    }

    default RowMapper<TagDto> TagRowMapper(){
        return (rs, rowNum)->{
            TagDto tagDto = new TagDto();
            tagDto.setType(rs.getString("type"));
            String[] nameStrings=rs.getString("names").split(",");
            String[] idStrings=rs.getString("ids").split(",");
            List<TagDetailDto> tagDetailDtos=new ArrayList<>();
            for(int i=0;i<nameStrings.length;i++){
                TagDetailDto tagDetailDto = new TagDetailDto();
                tagDetailDto.setName(nameStrings[i]);
                tagDetailDto.setIds(Integer.parseInt(idStrings[i]));
                tagDetailDtos.add(tagDetailDto);
            }
            tagDto.setDetailTags(tagDetailDtos);
            return tagDto;
        };
    }
}
