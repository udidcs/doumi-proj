package com.example.doumiproject.controller;

import com.example.doumiproject.dto.PostDto;
import com.example.doumiproject.service.QuizService;
import com.example.doumiproject.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;


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
}
