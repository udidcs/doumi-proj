package com.example.doumiproject.controller;

import com.example.doumiproject.dto.PostDto;
import com.example.doumiproject.service.QuizService;
import com.example.doumiproject.util.PaginationUtil;
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
    private int pageSize = 10;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1", value = "page") int page, Model model) {

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
}
