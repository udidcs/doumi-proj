package com.example.doumiproject.controller;

import com.example.doumiproject.dto.*;
import com.example.doumiproject.service.QuizService;
import com.example.doumiproject.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {

        int pageSize = 10;
        int totalPages = quizService.getTotalPages(pageSize);
        int startIdx = PaginationUtil.calculateStartIndex(page, totalPages);
        int endIdx = PaginationUtil.calculateEndIndex(page, totalPages);

        List<PostDto> quizs = quizService.getAllQuiz(page, pageSize);

        model.addAttribute("quizs", quizs);
        model.addAttribute("currentPage", page);
        model.addAttribute("startIdx", startIdx);
        model.addAttribute("endIdx", endIdx);
        model.addAttribute("totalPages", totalPages);

        return "quiz/index";
    }

    @GetMapping("/{id}")
    public String getQuizDetail(@PathVariable Long id, Model model){
        QuizDto quizDetail=quizService.getQuizDetail(id);
        List<String> tags=quizService.getTags(id);
        List<CommentDto> comments=quizService.getComments(id);
        model.addAttribute("quiz",quizDetail);
        model.addAttribute("tags",tags);
        model.addAttribute("comments",comments);
        return "quiz/board";
    }

    @GetMapping("/post")
    public String createQuiz(Model model){
        List<TagDto> tags = quizService.getAllTags();
        model.addAttribute("tags",tags);
        model.addAttribute("QuizVO",new QuizVO());
        return "quiz/form";
    }

    @PostMapping("/quiz/post")
    public String postQuiz(QuizVO quizVO) {
        System.out.println(quizVO);
        Long postId = quizService.saveQuiz(quizVO, 1l);
        return "redirect:/quiz/";
    }
}
