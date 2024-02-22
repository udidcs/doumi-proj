package com.example.doumiproject.repository;

import com.example.doumiproject.dto.CommentDto;
import com.example.doumiproject.dto.ReCommentDto;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface CommentRepository {
    public List<CommentDto> getByQuizId(long postId);
    public List<ReCommentDto> getByParentCommentId(long parentCommentId);

    default RowMapper<CommentDto> commentRowMapper(){
        return (rs,rowNum)->{
            CommentDto commentDto = new CommentDto();
            commentDto.setId(rs.getLong("id"));
            commentDto.setUserId(rs.getString("user_id"));
            commentDto.setContents(rs.getString("contents"));
            commentDto.setLike(rs.getInt("like"));
            commentDto.setDisplay(rs.getInt("display"));
            commentDto.setCreatedAt(rs.getTimestamp("created_at"));
            return commentDto;
        };
    }

    default RowMapper<ReCommentDto> reCommentRowMapper(){
        return (rs,rowNum)->{
            ReCommentDto reCommentDto = new ReCommentDto();
            reCommentDto.setId(rs.getLong("id"));
            reCommentDto.setUserId(rs.getString("nickname"));
            reCommentDto.setContents(rs.getString("contents"));
            reCommentDto.setLike(rs.getLong("like"));
            reCommentDto.setDisplay(rs.getInt("display"));
            reCommentDto.setCreatedAt(rs.getTimestamp("created_at"));
            return reCommentDto;
        };
    }
}
