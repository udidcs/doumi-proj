package com.example.doumiproject.repository;

import com.example.doumiproject.entity.CoteBoard;
import com.example.doumiproject.responsedto.CoteBoardDto;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface CoteBoardRepository {
    public CoteBoard selectCoteBoardById(long post_id);
    int selectTotalPages(int pageSize);
    int selectTotalPages(int pageSize, String keyword);
    public List<CoteBoard> selectAllCoteBaords();
    public List<CoteBoard> selectAllCoteBaords(int page, int pageSize);
    public List<CoteBoard> selectAllCoteBaords(int page, int pageSize, String keyword);

    //    public Long saveQuiz(Quiz quiz, long userId);
//    void updateQuiz(Quiz quiz, long postId, long userId);
//    void deleteQuiz(long postId);
//
//    List<TagDetailDto> getTags(long id);
//
    default RowMapper<CoteBoard> coteBoardDtoRowMapper() {
        return ((rs, rowNum) -> {
            CoteBoard coteBoard=new CoteBoard();
            coteBoard.setId(rs.getLong("id"));
            coteBoard.setUser_id(rs.getLong("user_id"));
            coteBoard.setTitle(rs.getString("title"));
            coteBoard.setContents(rs.getString("contents"));
            coteBoard.setView_count(rs.getLong("view_count"));
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
