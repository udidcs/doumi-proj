package com.example.doumiproject.repository;

import com.example.doumiproject.responsedto.CommentDto;
import com.example.doumiproject.responsedto.ReCommentDto;
import com.example.doumiproject.entity.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface CommentRepository {
    public List<CommentDto> getByQuizId(long postId);
    public List<ReCommentDto> getByParentCommentId(long parentCommentId);
    public void saveComment(Comment comment, long userId, String type);

    default RowMapper<CommentDto> commentRowMapper(){
        return (rs,rowNum)->{
            CommentDto commentDto = new CommentDto();
            commentDto.setId(rs.getLong("comment_id"));
            commentDto.setUserId(rs.getLong("user_id"));
            commentDto.setAuthor(rs.getString("author"));
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
            reCommentDto.setId(rs.getLong("re_comment_id"));
            reCommentDto.setUserId(rs.getLong("user_id"));
            reCommentDto.setAuthor(rs.getString("author"));
            reCommentDto.setContents(rs.getString("contents"));
            reCommentDto.setLike(rs.getLong("like"));
            reCommentDto.setDisplay(rs.getInt("display"));
            reCommentDto.setCreatedAt(rs.getTimestamp("created_at"));
            return reCommentDto;
        };
    }
}
