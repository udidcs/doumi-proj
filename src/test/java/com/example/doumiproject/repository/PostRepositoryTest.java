package com.example.doumiproject.repository;

import com.example.doumiproject.dto.PostDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

        List<PostDto> quizs = postRepository.findAllQuiz(2, 10);

        for(PostDto postDto : quizs) {
            System.out.println(postDto.getId()+" "+postDto.getTitle()+" "+postDto.getContents());
        }
    }

    @Test
    @DisplayName("총 페이지 수 출력하기")
    public void getTotalPagesTest() {

        System.out.println(postRepository.getTotalPages(10));

        Assertions.assertEquals(8, postRepository.getTotalPages(10));
    }

    @Test
    @DisplayName("제목 or 작성자 검색 결과 출력하기")
    public void findByTitleOrAuthorTest() {

        String search = "퀴즈";

        List<PostDto> quizs = postRepository.findByTitleOrAuthor(search, 3, 10);

        for(PostDto postDto : quizs) {
            System.out.println(postDto.getId()+" "+postDto.getTitle()+" "+postDto.getContents());
        }
    }

    @Test
    @DisplayName("제목 or 작성자 검색시 총 페이지 수 출력하기")
    public void getTotalPagesFindByTitleOrAuthorTest() {

        String keyword = "user1";

        Assertions.assertEquals(5, postRepository.getTotalPages(10, keyword));
    }
}