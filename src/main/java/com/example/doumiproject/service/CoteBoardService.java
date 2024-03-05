package com.example.doumiproject.service;

import com.example.doumiproject.requestdto.CoteBoardRequestDto;
import com.example.doumiproject.responsedto.CoteBoardResponseDto;

import java.util.List;

public interface CoteBoardService {
    public CoteBoardResponseDto getCoteBoard(long postId);
    public List<CoteBoardResponseDto> getAllCoteBoards(int page, int pageSize);
    public List<CoteBoardResponseDto> getAllCoteBoards(int page, int pageSize, String keyword);

    public int getTotalPages(int pageSize);
    public int getTotalPages(int pageSize, String keyword);
    public int setCoteBoard(CoteBoardRequestDto coteBoardRequestDto);



//    public List<TagDto> getAllTags();
////    public Long saveQuiz(Quiz quiz, Long userId);

//    public List<PostDto> getSearchQuiz(String keyword, int page, int pageSize);
////    public void updateQuiz(Quiz quiz, Long postId, Long userId);
//    public void deleteQuiz(long postId);

}

