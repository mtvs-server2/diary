package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.service.PhraseService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/phrases")
public class PhraseController {

    private final PhraseService phraseService;

    @PostMapping("/{userId}")
    @ResponseBody
    public ResponseEntity registPhrase(@PathVariable String userId, @RequestBody String phrase) {

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        try {
            phraseService.registPhraseToUser(userId, phrase);
            return new ResponseEntity(headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            return new ResponseEntity(message, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/test")
    public String getTest() {

        return "test/test";
    }
}
