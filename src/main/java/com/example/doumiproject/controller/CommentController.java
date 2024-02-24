package com.example.doumiproject.controller;

import com.example.doumiproject.dto.CommentDto;
import com.example.doumiproject.entity.Comment;
import com.example.doumiproject.service.CommentService;
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

    @PostMapping("/add")
    public String addComment(@ModelAttribute("newComment") Comment comment, Model model){
        System.out.println(comment);

        //로그인 기능 생기면 수정해야함
        Long commentId = commentService.saveComment(comment, 2, "QUIZ");

        //저장한 댓글 가져오기
//        CommentDto commentDto = commentService.getComment(commentId);

        //return ResponseEntity.status(HttpStatus.CREATED).body(commentDto);
        return "redirect:/quiz/board?id="+comment.getPostId();
    }
}
