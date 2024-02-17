package com.example.doumiproject.service;

import com.example.doumiproject.dto.PostDto;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface QuizService {

    public List<PostDto> getAllQuiz(int page, int pageSize);
    public List<PostDto> getAllQuiz();
    public int getTotalPages(int pageSize);
    public int getTotalPages(int pageSize, String keyword);
    public List<PostDto> getSearchQuiz(String keyword, int page, int pageSize);
}
