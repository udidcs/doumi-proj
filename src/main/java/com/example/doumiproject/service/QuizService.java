package com.example.doumiproject.service;

import com.example.doumiproject.dto.*;

import java.util.List;

public interface QuizService {
    public List<PostDto> getAllQuiz(int page, int pageSize);
    public List<PostDto> getAllQuiz();
    public int getTotalPages(int pageSize);
    public QuizDto getQuizDetail(long postId);
    public List<TagDetailDto> getTags(long postId);
    public List<CommentDto> getComments(long postId);
    public List<TagDto> getAllTags();
    public Long saveQuiz(QuizVO quizVO, Long userId);
    public int getTotalPages(int pageSize, String keyword);
    public List<PostDto> getSearchQuiz(String keyword, int page, int pageSize);
    public void updateQuiz(QuizVO quizVO, Long postId, Long userId);
    public void deleteQuiz(long postId);
}

