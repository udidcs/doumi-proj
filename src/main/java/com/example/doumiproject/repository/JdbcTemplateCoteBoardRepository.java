package com.example.doumiproject.repository;

import com.example.doumiproject.entity.CoteBoard;
import com.example.doumiproject.responsedto.CoteBoardDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcTemplateCoteBoardRepository implements CoteBoardRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateCoteBoardRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public CoteBoard selectCoteBoardById(long post_id) {

        String sql = "select id, user_id, title, contents, view_count " +
                "from coteboard " +
                "where id = ?";

        CoteBoard coteBoard = jdbcTemplate.queryForObject(sql, coteBoardDtoRowMapper(), post_id);
        return coteBoard;
    }

    @Override
    public int selectTotalPages(int pageSize) {
        String sql = "select ceil(count(*) / ?) as totalPages " +
                "from coteboard";

        return jdbcTemplate.queryForObject(sql, Integer.class, pageSize);
    }

    @Override
    public int selectTotalPages(int pageSize, String keyword) {

        String param = "%"+keyword+"%";

        String sql = "select ceil(count(*) / ?) as totalPages " +
                "from coteboard " +
                "where title like ? or user_id like ?";

        return jdbcTemplate.queryForObject(sql, Integer.class, pageSize, param, param);
    }

    @Override
    public List<CoteBoard> selectAllCoteBaords() {

        String sql = "select id, user_id, title, contents, view_count " +
                "from coteboard " +
                "order by " +
                "id desc";

        List<CoteBoard> coteBoardList = jdbcTemplate.query(sql, coteBoardDtoRowMapper());
        return coteBoardList;
    }

    @Override
    public List<CoteBoard> selectAllCoteBaords(int page, int pageSize) {

        int offset = (page - 1) * pageSize;
        String sql = "select id, user_id, title, contents, view_count " +
                "from coteboard " +
                "order by " +
                "id desc " +
                "limit ? offset ?";

        List<CoteBoard> coteBoardList = jdbcTemplate.query(sql, coteBoardDtoRowMapper(), pageSize, offset);
        return coteBoardList;
    }


    @Override
    public List<CoteBoard> selectAllCoteBaords(int page, int pageSize, String keyword) {

        String param = "%"+keyword+"%";
        int offset = (page - 1) * pageSize;

        String sql = "select id, user_id, title, contents, view_count " +
                "from coteboard " +
                "where title like ? or user_id like ? " +
                "order by " +
                "id desc " +
                "limit ? offset ?";

        List<CoteBoard> coteBoardList = jdbcTemplate.query(sql, coteBoardDtoRowMapper(), param, param, pageSize, offset);
        return coteBoardList;
    }


//    @Override
//    public Long saveQuiz(Quiz quiz, long userId) {
//        //게시글 저장
//        String postSql = "insert into post (user_id, type, title, contents, created_at, updated_at, `like`) " +
//                "values (?, ?, ?, ?, ?, ?, ?)";
//
//        //생성된 키 값 받아오기
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(postSql, new String[]{"id"}); // "id"는 자동 생성된 키의 컬럼명
//            ps.setLong(1, userId);
//            ps.setString(2, "QUIZ");
//            ps.setString(3, quiz.getTitle());
//            ps.setString(4, quiz.getQuizContent());
//            ps.setObject(5, LocalDateTime.now());
//            ps.setObject(6, LocalDateTime.now());
//            ps.setInt(7, 0);
//            return ps;
//        }, keyHolder);
//
//        //게시글을 저장한 후 생성된 postId 가져오기
//        Long postId = keyHolder.getKey().longValue();
//
//        //퀴즈 답변 저장
//        String answerSql = "insert into answer(post_id, answer) " +
//                "values (?,?)";
//        String answer = quiz.getAnswerContent();
//
//        jdbcTemplate.update(answerSql, postId, answer);
//
//        //태그 저장
//        saveTags(quiz,postId);
//        return postId;
//    }
//
//    @Override
//    public void updateQuiz(Quiz quiz, long postId, long userId) {
//        //로그인 생기면 수정 권한 있는지 확인 로직 where에 추가
//        String postSql="update post "+
//                "set title=?, contents=?, updated_at = ? "+
//                "where id = ?";
//        jdbcTemplate.update(postSql,
//                quiz.getTitle(),quiz.getQuizContent(),LocalDateTime.now()
//                ,postId,userId);
//
//        String answerSql="update answer "+
//                "set answer=? "+
//                "where post_id=?";
//        jdbcTemplate.update(answerSql,quiz.getAnswerContent(),postId);
//
//        // 기존 태그 삭제 후 새로운 태그 추가
//        String deleteTagsSql = "delete from quiztag where post_id = ?";
//        jdbcTemplate.update(deleteTagsSql, postId);
//
//        saveTags(quiz,postId);
//    }
//
//    @Override
//    public void deleteQuiz(long postId) {
//        String sql="delete from post where id=?";
//        jdbcTemplate.update(sql, postId);
//    }
//
//    //태그 저장
//    public void saveTags(Quiz quiz, long postId){
//        String tagSql = "insert into quiztag (post_id, tag_id) " +
//                "values (?,?)";
//        String tags = quiz.getTags();
//        if (!tags.isEmpty()) {
//            String[] tagStrings = quiz.getTags().split(",");
//            for (String tag : tagStrings) {
//                jdbcTemplate.update(tagSql, postId, Integer.parseInt(tag));
//            }
//        }
//    }

}