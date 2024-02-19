package com.example.doumiproject.repository;

import com.example.doumiproject.dto.QuizDto;
import com.example.doumiproject.dto.QuizVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Repository
public class JdbcTemplateQuizRepository implements QuizRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateQuizRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public QuizDto getByQuizId(long id) {
        String sql = "select p.id as post_id, p.user_id, p.title, p.contents, p.created_at, p.like, a.answer, " +
                "u.nickname " +
                "from post p " +
                "inner join answer a on p.id = a.post_id " +
                "inner join user u on p.user_id = u.id " +
                "where p.id = ?";
        return jdbcTemplate.queryForObject(sql, quizDtoRowMapper(), id);
    }

    @Override
    public Long saveQuiz(QuizVO quiz, long userId) {
        //게시글 저장
        String postSql = "insert into post (user_id, type, title, contents, created_at, updated_at, `like`) " +
                "values (?, ?, ?, ?, ?, ?, ?)";

        //생성된 키 값 받아오기
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(postSql, new String[]{"id"}); // "id"는 자동 생성된 키의 컬럼명
            ps.setLong(1, userId);
            ps.setString(2, "퀴즈");
            ps.setString(3, quiz.getTitle());
            ps.setString(4, quiz.getQuizContent());
            ps.setObject(5, LocalDateTime.now());
            ps.setObject(6, LocalDateTime.now());
            ps.setInt(7, 0);
            return ps;
        }, keyHolder);

        //게시글을 저장한 후 생성된 postId 가져오기
        Long postId = keyHolder.getKey().longValue();

        //퀴즈 답변 저장
        String answerSql = "insert into answer(post_id, answer) " +
                "values (?,?)";
        String answer = quiz.getAnswerContent();

        if (answer.isEmpty()) {
            jdbcTemplate.update(answerSql,postId,null);
        } else {
            jdbcTemplate.update(answerSql, postId, answer);
        }

        //태그 저장
        String tagSql = "insert into quiztag (post_id, tag_id) " +
                "values (?,?)";
        String tags = quiz.getTags();
        if (!tags.isEmpty()) {
            String[] tagStrings = quiz.getTags().split(",");
            for (String tag : tagStrings) {
                jdbcTemplate.update(tagSql, postId, Integer.parseInt(tag));
            }
        }
        return postId;
    }
}