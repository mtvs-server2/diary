package com.diary.diaryproject.application.controller;

import com.diary.diaryproject.application.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    @Autowired
    LoginService loginService;


    }

