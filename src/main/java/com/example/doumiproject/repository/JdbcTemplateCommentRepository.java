package com.example.doumiproject.repository;

import com.example.doumiproject.dto.CommentDto;
import com.example.doumiproject.dto.ReCommentDto;
import com.example.doumiproject.entity.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcTemplateCommentRepository implements CommentRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateCommentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CommentDto> getByQuizId(long postId) {
        String sql = "select c.id as comment_id ,u.id as user_id, u.user_id as author , c.contents, c.created_at, c.like, c.display " +
                "from comment c " +
                "inner join user u on u.id=c.user_id " +
                "where c.post_id=? " +
                "and c.parent_comment_id=0 " +
                "order by c.created_at ASC";

        List<CommentDto> comments = jdbcTemplate.query(sql, commentRowMapper(), postId);

        for (CommentDto comment : comments) {
            List<ReCommentDto> reComments = getByParentCommentId(comment.getId());
            comment.setReComments(reComments);
        }

        return comments;
    }


    @Override
    public List<ReCommentDto> getByParentCommentId(long parentCommentId) {
        // 1. 부모 댓글 ID에 해당하는 모든 대댓글 목록을 조회
        //대댓글 시간순 정렬
        String sql = "select c.id as re_comment_id ,u.id as user_id, u.user_id as author, c.contents, c.created_at, c.like, c.display " +
                "from comment c " +
                "inner join user u on u.id=c.user_id " +
                "where c.parent_comment_id=? " +
                "order by c.created_at ASC";

        return jdbcTemplate.query(sql, reCommentRowMapper(), parentCommentId);
    }

    @Override
    public Long saveComment(Comment comment, long userId, String type) {

        String sql = "insert into comment(user_id, post_id, type, contents, created_at, updated_at, `like`, display, parent_comment_id) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        int display;
        //체크 박스 선택한 상태이면
        if (comment.isDisplay()) {
            //1로 바꿔줌(비공개 설정)
            display = 1;
        } else {
            //체크 해제 상태면 0(공개 설정)
            display = 0;
        }

        //생성된 키 값 받아오기
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setLong(1, userId);
            ps.setLong(2, comment.getPostId());
            ps.setString(3, "QUIZ");
            ps.setString(4, comment.getContents());
            ps.setObject(5, LocalDateTime.now());
            ps.setObject(6, LocalDateTime.now());
            ps.setInt(7, 0);
            ps.setInt(8, display);
            ps.setLong(9, comment.getParentCommentId());
            return ps;
        },keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public CommentDto getByCommentId(long commentId) {
        String sql = "select c.id as comment_id ,u.id as user_id, u.user_id as author , c.contents, c.created_at, c.like, c.display " +
                "from comment c " +
                "inner join user u on c.user_id=u.id "+
                "where c.id=?";
        return jdbcTemplate.queryForObject(sql, commentRowMapper(), commentId);
    }
}
