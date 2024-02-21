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
@RequiredArgsConstructor
@RequestMapping("/codingtest")
public class CodingTestController {
    @GetMapping
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {

        return "codingtest/timeComplexity";
    }
}
