package com.example.doumiproject.repository;

import com.example.doumiproject.entity.CoteBoard;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface CoteBoardRepository {
    public CoteBoard selectCoteBoardById(long post_id);
    int selectTotalPages(int pageSize);
    int selectTotalPages(int pageSize, String keyword);
    public List<CoteBoard> selectAllCoteBaords();
    public List<CoteBoard> selectAllCoteBaords(int page, int pageSize);
    public List<CoteBoard> selectAllCoteBaords(int page, int pageSize, String keyword);
    public int insertCoteBoard(CoteBoard coteBoard);

    //    public Long saveQuiz(Quiz quiz, long userId);
//    void updateQuiz(Quiz quiz, long postId, long userId);
//    void deleteQuiz(long postId);
//
//    List<TagDetailDto> getTags(long id);
//
    default RowMapper<CoteBoard> coteBoardRowMapper() {
        return ((rs, rowNum) -> {
            CoteBoard coteBoard = new CoteBoard();
            coteBoard.setId(rs.getInt("id"));
            coteBoard.setWriter(rs.getString("writer"));
            coteBoard.setBoardPassword("board_password");
            coteBoard.setTitle(rs.getString("title"));
            coteBoard.setContents(rs.getString("contents"));
            coteBoard.setViewCount(rs.getInt("view_count"));
            coteBoard.setCreatedAt(rs.getTimestamp("created_at"));
            coteBoard.setCreatedAt(rs.getTimestamp("updated_at"));
            return coteBoard;
        });
    }




//
//    default RowMapper<TagDetailDto> TagRowMapper() {
//        return (rs,rowNum)->{
//            TagDetailDto tagDetailDto = new TagDetailDto();
//            tagDetailDto.setId(rs.getLong("id"));
//            tagDetailDto.setName(rs.getString("name"));
//            return tagDetailDto;
//        };
//    }
}
