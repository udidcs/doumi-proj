package com.example.doumiproject.controller;

import com.example.doumiproject.dto.*;
import com.example.doumiproject.service.QuizService;
import com.example.doumiproject.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private int pageSize = 10;

    public String index(@RequestParam(defaultValue = "1") int page, Model model) {

        if (page < 1) {
            page = 1;
        }

        setPaginationAttributes(model, page,
                quizService.getTotalPages(pageSize), quizService.getAllQuiz(page, pageSize));

        return "quiz/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword") String keyword,
                         @RequestParam(defaultValue = "1", value = "page") int page, Model model) {

        if (page < 1) {
            page = 1;
        }

        setPaginationAttributes(model, page,
                quizService.getTotalPages(pageSize, keyword), quizService.getSearchQuiz(keyword, page, pageSize));
        model.addAttribute("keyword", keyword);

        return "quiz/search";
    }

    private void setPaginationAttributes(Model model, int page, int totalPages, List<PostDto> quizs) {

        int startIdx = PaginationUtil.calculateStartIndex(page);
        int endIdx = PaginationUtil.calculateEndIndex(page, totalPages);

        model.addAttribute("quizs", quizs);
        model.addAttribute("currentPage", page);
        model.addAttribute("startIdx", startIdx);
        model.addAttribute("endIdx", endIdx);
        model.addAttribute("totalPages", totalPages);
    }

    @GetMapping("/board")
    public String getQuizDetail(@RequestParam("id") Long id, Model model){
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

    @PostMapping("/post")
    public ResponseEntity<String> postQuiz(QuizVO quizVO) {
        Long postId = quizService.saveQuiz(quizVO, 1l);
        return ResponseEntity.ok("/quiz/board?id="+postId);
    }
}
