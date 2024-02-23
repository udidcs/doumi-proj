package com.example.doumiproject.repository;

import com.example.doumiproject.dto.CommentDto;
import com.example.doumiproject.dto.ReCommentDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTemplateCommentRepository implements CommentRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateCommentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    @Override
    public List<CommentDto> getByQuizId(long postId) {
        String sql="select c.id, u.userId, c.contents, c.created_at, c.like, c.display "+
                "from comment c "+
                "inner join user u on u.id=c.user_id "+
                "where c.post_id=? "+
                "and c.parent_comment_id is null "+
                "order by c.created_at ASC";
        List<CommentDto> comments = jdbcTemplate.query(sql, commentRowMapper(), postId);
        for(CommentDto comment: comments){
            List<ReCommentDto> reComments=getByParentCommentId(comment.getId());
            comment.setReComments(reComments);
        }
        return comments;
    }


    @Override
    public List<ReCommentDto> getByParentCommentId(long parentCommentId) {
        // 1. 부모 댓글 ID에 해당하는 모든 대댓글 목록을 조회
        //대댓글 시간순 정렬
        String sql="select c.id, u.userId, c.contents, c.created_at, c.like, c.display "+
                "from comment c "+
                "inner join user u on u.id=c.user_id "+
                "where c.parent_comment_id=? "+
                "order by c.created_at ASC";

        return jdbcTemplate.query(sql, reCommentRowMapper(), parentCommentId);
    }
}
