package com.example.doumiproject.repository;

import com.example.doumiproject.entity.CoteBoard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class JdbcTemplateCoteBoardRepository implements CoteBoardRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateCoteBoardRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public CoteBoard selectCoteBoardById(long id) {

        String sql = "select id, writer, title, contents, view_count, created_at, updated_at " +
                "from coteboard " +
                "where id = ?";

        CoteBoard coteBoard = jdbcTemplate.queryForObject(sql, coteBoardRowMapper(), id);
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
                "where title like ? or writer like ?";

        return jdbcTemplate.queryForObject(sql, Integer.class, pageSize, param, param);
    }

    @Override
    public List<CoteBoard> selectAllCoteBaords() {

        String sql = "select id, writer, title, contents, view_count, created_at, updated_at " +
                "from coteboard " +
                "order by " +
                "id desc";

        List<CoteBoard> coteBoardList = jdbcTemplate.query(sql, coteBoardRowMapper());
        return coteBoardList;
    }

    @Override
    public List<CoteBoard> selectAllCoteBaords(int page, int pageSize) {

        int offset = (page - 1) * pageSize;
        String sql = "select id, writer, board_password, title, contents, view_count, created_at, updated_at " +
                "from coteboard " +
                "order by " +
                "id desc " +
                "limit ? offset ?";

        List<CoteBoard> coteBoardList = jdbcTemplate.query(sql, coteBoardRowMapper(), pageSize, offset);
        return coteBoardList;
    }


    @Override
    public List<CoteBoard> selectAllCoteBaords(int page, int pageSize, String keyword) {

        String param = "%"+keyword+"%";
        int offset = (page - 1) * pageSize;

        String sql = "select id, writer, title, contents, view_count, created_at, updated_at " +
                "from coteboard " +
                "where title like ? or writer like ? " +
                "order by " +
                "id desc " +
                "limit ? offset ?";

        List<CoteBoard> coteBoardList = jdbcTemplate.query(sql, coteBoardRowMapper(), param, param, pageSize, offset);
        return coteBoardList;
    }


    @Override
    public int insertCoteBoard(CoteBoard coteBoard) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement("insert into coteboard(writer, board_password, title, contents, view_count, created_at, updated_at) " +
                            "values (?, ?, ?, ?, ?, DATE_FORMAT(now(), '%y-%m-%d %H:%m:%s'), null)", new String[]{"id"});
                    ps.setString(1, coteBoard.getWriter());
                    ps.setString(2, coteBoard.getBoardPassword());
                    ps.setString(3, coteBoard.getTitle());
                    ps.setString(4, coteBoard.getContents());
                    ps.setInt(5, coteBoard.getViewCount());
                    return ps;
                },
                keyHolder
        );

        int generatedId = keyHolder.getKey().intValue();
        return generatedId;


    }
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