package com.example.doumiproject.repository;

import com.example.doumiproject.entity.CoteBoardComment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcTemplateCoteBoardCommentRepository implements CoteBoardCommentRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateCoteBoardCommentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CoteBoardComment> selectAllCoteBoardCommentUnderBoardByPostId(int id) {
        String sql = "select id, writer, comment_password, post_id, contents, parent_comment_id, created_at, updated_at " +
                "from coteboardcomment " +
                "where post_id=? " +
                "and parent_comment_id=0 " +
                "order by created_at DESC";

        List<CoteBoardComment> coteBoardCommentList = jdbcTemplate.query(sql, coteBoardCommentRowMapper(), id);

        return coteBoardCommentList;
    }

    @Override
    public List<CoteBoardComment> selectAllCoteBoardReCommentUnderCommentByParentCommentId(int id) {
        String sql = "select id, writer, comment_password, post_id, contents, parent_comment_id, created_at, updated_at " +
                "from coteboardcomment " +
                "where parent_comment_id=? " +
                "order by created_at DESC";

        List<CoteBoardComment> coteBoardCommentList = jdbcTemplate.query(sql, coteBoardCommentRowMapper(), id);

        return coteBoardCommentList;
    }

    @Override
    public void insertCoteBoardComment(CoteBoardComment coteBoardComment) {

        String sql = "insert into coteboardcomment(writer, comment_password, post_id, contents, parent_comment_id, created_at, updated_at) " +
                "values (?, ?, ?, ?, ?, ?, ?) ";

        jdbcTemplate.update(sql, coteBoardComment.getWriter(), coteBoardComment.getCommentPassword(), coteBoardComment.getPostId(), coteBoardComment.getContents(),
                coteBoardComment.getParentCommentId(), LocalDateTime.now(), LocalDateTime.now());
    }

//
//    @Override
//    public List<ReCommentDto> getByParentCommentId(long parentCommentId) {
//        // 1. 부모 댓글 ID에 해당하는 모든 대댓글 목록을 조회
//        //대댓글 시간순 정렬
//        String sql = "select c.id as re_comment_id ,u.id as user_id, u.user_id as author, c.contents, c.created_at, c.like, c.display " +
//                "from comment c " +
//                "inner join user u on u.id=c.user_id " +
//                "where c.parent_comment_id=? " +
//                "order by c.created_at ASC";
//
//        return jdbcTemplate.query(sql, reCommentRowMapper(), parentCommentId);
//    }
//
//    @Override
//    public void saveComment(CoteBoardComment comment, long userId, String type) {
//
//        String sql = "insert into comment(user_id, post_id, type, contents, created_at, updated_at, `like`, display, parent_comment_id) " +
//                "values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
//
//        jdbcTemplate.update(sql, userId, comment.getPostId(), type, comment.getContents(),
//                LocalDateTime.now(),LocalDateTime.now(),0,comment.getParentCommentId());
//    }
}
