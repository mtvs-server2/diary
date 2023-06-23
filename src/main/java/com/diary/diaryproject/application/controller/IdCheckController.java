package com.diary.diaryproject.application.controller;

import com.diary.diaryproject.application.service.SignUpService;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.service.IdCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IdCheckController {

    private SignUpService signUpService;
    @Autowired
    public IdCheckController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    public void IdCheck(User id) {

    }
}
