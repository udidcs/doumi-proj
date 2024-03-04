package com.example.doumiproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "start";
    }

    @GetMapping("/user/login")
    public String login() { return "login"; }

    @GetMapping("/user/signup")
    public String signUp() { return "signUp"; }
}
