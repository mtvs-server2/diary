package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.service.PhraseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/phrases")
public class PhraseController {

    private final PhraseService phraseService;

    @GetMapping("/ping")
    public String ping() {

        return "ping";
    }

    @GetMapping("/test")
    public Object test() {

        return phraseService.test();
    }
}
