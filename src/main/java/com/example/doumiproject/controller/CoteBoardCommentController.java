package com.example.doumiproject.controller;

import com.example.doumiproject.entity.CoteBoard;
import com.example.doumiproject.entity.CoteBoardComment;
import com.example.doumiproject.requestdto.CoteBoardCommentRequestDto;
import com.example.doumiproject.responsedto.CoteBoardCommentResponseDto;
import com.example.doumiproject.service.CoteBoardCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class CoteBoardCommentController {
    private final CoteBoardCommentService coteBoardCommentService;

    @PostMapping("/comment/save")
    public String addComment(@ModelAttribute CoteBoardCommentRequestDto coteBoardComment, Model model){

        int post_id = coteBoardComment.getPostId();

        //로그인 기능 생기면 userId 방식 수정해야함
        coteBoardCommentService.saveCoteBoardComment(coteBoardComment);

        //글의 상세 정보 가져오기
        //QuizDto quiz=quizService.getQuiz(comment.getPostId());
        //글에 연결된 댓글들 가져오기
        List<CoteBoardCommentResponseDto> allCoteBoardComments = coteBoardCommentService.getAllCoteBoardComments(post_id);

        //저장한 댓글 가져오기
        model.addAttribute("postId", post_id);
        model.addAttribute("comments",allCoteBoardComments);
        CoteBoard coteBoard = new CoteBoard();
        coteBoard.setWriter("김이이");
        model.addAttribute("newComment", coteBoard);

        return "comment/comment";
    }

//    @PostMapping("/editForm")
//    public String getEditForm(@RequestBody Comment comment, Model model){
//
//        model.addAttribute("comment",comment);
//
//        return "comment/commentEditForm";
//    }
//
//    @PostMapping("/edit")
//    public String editComment(@RequestParam("id") long commentId, @ModelAttribute("comment") Comment comment,Model model){
//
//        //댓글 업데이트
//        commentService.updateComment(comment, commentId);
//
//        //글의 상세 정보 가져오기
//        //QuizDto quiz=quizService.getQuiz(comment.getPostId());
//        //글에 연결된 댓글들 가져오기
//        List<CommentDto> comments=commentService.getAllComments(comment.getPostId());
//
//        //model.addAttribute("quiz",quiz);
//        model.addAttribute("comments",comments);
//        model.addAttribute("newComment",new Comment());
//
//        return "comment/comment";
//    }
//
//    @DeleteMapping("/delete")
//    public String deleteComment(@RequestParam("postId") long postId, @RequestParam("commentId") long commentId,Model model){
//        commentService.deleteComment(commentId);
//
//        //글의 상세 정보 가져오기
//        QuizDto quiz=quizService.getQuiz(postId);
//        //글에 연결된 댓글들 가져오기
//        List<CommentDto> comments=commentService.getAllComments(postId);
//
//        model.addAttribute("quiz",quiz);
//        model.addAttribute("comments",comments);
//        model.addAttribute("newComment",new Comment());
//
//        return "comment/comment";
//
//    }

}
