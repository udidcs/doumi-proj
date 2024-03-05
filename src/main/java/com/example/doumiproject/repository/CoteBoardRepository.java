package com.example.doumiproject.repository;

import com.example.doumiproject.entity.CoteBoard;
import com.example.doumiproject.requestdto.CoteBoardRequestDto;
import com.example.doumiproject.responsedto.CoteBoardResponseDto;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface CoteBoardRepository {
    public CoteBoardResponseDto selectCoteBoardById(long post_id);
    int selectTotalPages(int pageSize);
    int selectTotalPages(int pageSize, String keyword);
    public List<CoteBoardResponseDto> selectAllCoteBaords();
    public List<CoteBoardResponseDto> selectAllCoteBaords(int page, int pageSize);
    public List<CoteBoardResponseDto> selectAllCoteBaords(int page, int pageSize, String keyword);
    public int insertCoteBoard(CoteBoard coteBoard);

    //    public Long saveQuiz(Quiz quiz, long userId);
//    void updateQuiz(Quiz quiz, long postId, long userId);
//    void deleteQuiz(long postId);
//
//    List<TagDetailDto> getTags(long id);
//
    default RowMapper<CoteBoardResponseDto> coteBoardDtoRowMapper() {
        return ((rs, rowNum) -> {
            CoteBoardResponseDto coteBoardResponseDto=new CoteBoardResponseDto();
            coteBoardResponseDto.setId(rs.getLong("id"));
            coteBoardResponseDto.setWriter(rs.getString("writer"));
            coteBoardResponseDto.setTitle(rs.getString("title"));
            coteBoardResponseDto.setContents(rs.getString("contents"));
            coteBoardResponseDto.setViewCount(rs.getLong("view_count"));
            return coteBoardResponseDto;
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
