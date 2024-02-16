package com.example.doumiproject.service;

import com.example.doumiproject.dto.PostDto;
import com.example.doumiproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{

    private final PostRepository postRepository;

    @Override
    public List<PostDto> getAllQuiz(int page, int pageSize) {

        return postRepository.findAllQuiz(page, pageSize);
    }

    @Override
    public List<PostDto> getAllQuiz() {

        return postRepository.findAllQuiz();
    }

    @Override
    public int getTotalPages(int pageSize) {

        return postRepository.getTotalPages(pageSize);
    }
}
