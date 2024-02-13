package com.example.doumiproject.controller;

import com.example.doumiproject.service.QuizService;
import com.example.doumiproject.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/")
    public String index(Model model) {

        List<PostVO> posts = quizService.getAllPost();

        model.addAttribute("posts", posts);

        return "quiz/index";
    }
}
