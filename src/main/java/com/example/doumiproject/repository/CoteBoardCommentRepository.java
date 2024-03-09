package com.example.doumiproject.repository;

import com.example.doumiproject.responsedto.ReCommentDto;
import com.example.doumiproject.entity.CoteBoardComment;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface CoteBoardCommentRepository {
    public List<CoteBoardComment> selectAllCoteBoardCommentUnderBoardByPostId(int id);
    public List<CoteBoardComment> selectAllCoteBoardReCommentUnderCommentByParentCommentId(int id);
    public void insertCoteBoardComment(CoteBoardComment comment);

    default RowMapper<CoteBoardComment> coteBoardCommentRowMapper(){
        return (rs,rowNum)->{
            CoteBoardComment coteBoardComment = new CoteBoardComment();
            coteBoardComment.setId(rs.getInt("id"));
            coteBoardComment.setWriter(rs.getString("writer"));
            coteBoardComment.setCommentPassword(rs.getString("comment_password"));
            coteBoardComment.setPostId(rs.getInt("post_id"));
            coteBoardComment.setContents(rs.getString("contents"));
            coteBoardComment.setParentCommentId(rs.getInt("parent_comment_id"));
            coteBoardComment.setCreatedAt(rs.getTimestamp("created_at"));
            coteBoardComment.setCreatedAt(rs.getTimestamp("updated_at"));
            return coteBoardComment;
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
