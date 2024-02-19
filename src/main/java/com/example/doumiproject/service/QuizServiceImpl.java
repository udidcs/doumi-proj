package com.example.doumiproject.service;

import com.example.doumiproject.dto.*;
import com.example.doumiproject.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{

    private final PostRepository postRepository;
    private final QuizRepository quizRepository;
    private final TagRepository tagRepository;
    private final CommentRepository commentRepository;

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
    @Override
    public QuizDto getQuizDetail(long postId){
        return quizRepository.getByQuizId(postId);
    }

    @Override
    public List<String> getTags(long postId) {
        return tagRepository.getByQuizId(postId);
    }

    @Override
    public List<CommentDto> getComments(long postId) {
        return commentRepository.getByQuizId(postId);
    }

    @Override
    public List<TagDto> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Long saveQuiz(QuizVO quizVO, Long userId) {
        return quizRepository.saveQuiz(quizVO,userId);
    }
}
