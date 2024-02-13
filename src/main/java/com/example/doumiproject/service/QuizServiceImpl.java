package com.example.doumiproject.service;

import com.example.doumiproject.repository.PostRepository;
import com.example.doumiproject.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{

    private final PostRepository postRepository;

    @Override
    public List<PostVO> getAllPost() {

        return postRepository.findAllPost();
    }
}
