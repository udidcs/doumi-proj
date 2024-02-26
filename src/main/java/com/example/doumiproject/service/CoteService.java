package com.example.doumiproject.service;

import com.example.doumiproject.dto.*;
import com.example.doumiproject.entity.Cote;
import com.example.doumiproject.entity.Quiz;

import java.util.List;

public interface CoteService {
    public List<PostDto> getAllQuiz(int page, int pageSize);
    public List<PostDto> getAllQuiz();
    public int getTotalPages(int pageSize);
    public CoteDto getQuiz(long postId);
    public List<CommentDto> getComments(long postId);
    public List<TagDto> getAllTags();
    public Long saveQuiz(Cote quiz, Long userId);
    public int getTotalPages(int pageSize, String keyword);
    public List<PostDto> getSearchQuiz(String keyword, int page, int pageSize);
    public void updateQuiz(Cote quiz, Long postId, Long userId);
    public void deleteQuiz(long postId);
}

