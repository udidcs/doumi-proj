package com.example.doumiproject.repository;

import com.example.doumiproject.dto.CoteDto;
import com.example.doumiproject.dto.QuizDto;
import com.example.doumiproject.dto.TagDetailDto;
import com.example.doumiproject.entity.Cote;
import com.example.doumiproject.entity.Quiz;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface CoteRepository {
    public CoteDto getByQuizId(long id);
    public Long saveQuiz(Cote quiz, long userId);
    void updateQuiz(Cote quiz, long postId, long userId);
    void deleteQuiz(long postId);

    List<TagDetailDto> getTags(long id);

    default RowMapper<CoteDto> quizDtoRowMapper() {
        return ((rs, rowNum) -> {
            CoteDto quizDto=new CoteDto();
            quizDto.setId(rs.getLong("post_id"));
            quizDto.setUserId(rs.getString("user_id"));
            quizDto.setTitle(rs.getString("title"));
            quizDto.setContents(rs.getString("contents"));
            quizDto.setCreatedAt(rs.getTimestamp("created_at"));
            quizDto.setLike(rs.getInt("like"));
            quizDto.setAnswer(rs.getString("answer"));
            return quizDto;
        });
    };

    default RowMapper<TagDetailDto> TagRowMapper() {
        return (rs,rowNum)->{
            TagDetailDto tagDetailDto = new TagDetailDto();
            tagDetailDto.setId(rs.getLong("id"));
            tagDetailDto.setName(rs.getString("name"));
            return tagDetailDto;
        };
    }
}
