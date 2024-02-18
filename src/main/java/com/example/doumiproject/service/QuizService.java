package com.example.doumiproject.service;

import com.example.doumiproject.dto.*;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface QuizService {

    public List<PostDto> getAllQuiz(int page, int pageSize);
    public List<PostDto> getAllQuiz();
    public int getTotalPages(int pageSize);
    public QuizDto getQuizDetail(long postId);
    public List<String> getTags(long postId);

    public List<CommentDto> getComments(long postId);
}

