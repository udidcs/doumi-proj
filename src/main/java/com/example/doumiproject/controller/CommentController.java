package com.example.doumiproject.controller;

import com.example.doumiproject.dto.CommentDto;
import com.example.doumiproject.dto.QuizDto;
import com.example.doumiproject.entity.Comment;
import com.example.doumiproject.service.CommentService;
import com.example.doumiproject.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    private final QuizService quizService;

    @PostMapping("/add")
    public String addComment(@ModelAttribute("newComment") Comment comment, Model model){

        //로그인 기능 생기면 userId 방식 수정해야함
        commentService.saveComment(comment, 3, "QUIZ");

        //글의 상세 정보 가져오기
        QuizDto quiz=quizService.getQuiz(comment.getPostId());
        //글에 연결된 댓글들 가져오기
        List<CommentDto> comments=commentService.getAllComments(comment.getPostId());

        //저장한 댓글 가져오기
        model.addAttribute("quiz",quiz);
        model.addAttribute("comments",comments);
        model.addAttribute("newComment",new Comment());


        return "comment/comment";
    }
}
