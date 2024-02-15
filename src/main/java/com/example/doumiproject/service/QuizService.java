package com.example.doumiproject.service;

import com.example.doumiproject.dto.PostDto;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface QuizService {

    public List<PostDto> getAllQuiz(int page, int pageSize);
    public List<PostDto> getAllQuiz();
    @Cacheable
    public int getTotalPages(int pageSize);
}
