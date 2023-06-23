package com.diary.diaryproject.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class RegistMemberController {
    @GetMapping("register")
    public String register() {
        return "register";
    }
}

