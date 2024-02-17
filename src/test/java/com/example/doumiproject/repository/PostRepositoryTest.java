package com.example.doumiproject.repository;

import com.example.doumiproject.dto.PostDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @DisplayName("모든 퀴즈 목록 출력하기")
    public void findAllQuizTest() {

        List<PostDto> quizs = postRepository.findAllQuiz();

        for(PostDto postDto : quizs) {
            System.out.println(postDto.getId()+" "+postDto.getTitle()+" "+postDto.getContents());
        }
    }

    @Test
    @DisplayName("모든 퀴즈 목록 페이징 적용해서 출력하기")
    public void findAllQuizWithPaginationTest() {

        List<PostDto> quizs = postRepository.findAllQuiz(2, 8);

        for(PostDto postDto : quizs) {
            System.out.println(postDto.getId()+" "+postDto.getTitle()+" "+postDto.getContents());
        }
    }

    @Test
    @DisplayName("총 페이지 수 출력하기")
    public void getTotalPagesTest() {

        System.out.println(postRepository.getTotalPages(10));
    }
}