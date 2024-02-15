package com.example.doumiproject.controller;

import com.example.doumiproject.dto.PostDto;
import com.example.doumiproject.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {

        int pageSize = 5;
        int totalPages = quizService.getTotalPages(pageSize);
        int startIdx = page - 2;
        int endIdx = page + 2;

        if(startIdx <= 0) {
            startIdx = 1;
            endIdx = pageSize;
        }

        if(endIdx >= totalPages) {
            startIdx = totalPages - pageSize;
            endIdx = totalPages;
        }

        List<PostDto> quizs = quizService.getAllQuiz(page, pageSize);

        model.addAttribute("quizs", quizs);
        model.addAttribute("currentPage", page);
        model.addAttribute("startIdx", startIdx);
        model.addAttribute("endIdx", endIdx);
        model.addAttribute("totalPages", totalPages);

        return "quiz/index";
    }
}
