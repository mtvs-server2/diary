package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.dto.PhraseDto;
import com.diary.diaryproject.domain.service.PhraseService;
import lombok.RequiredArgsConstructor;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.time.LocalDate;

@RequiredArgsConstructor
@Controller
@RequestMapping("/phrases")
public class PhraseController {

    private final PhraseService phraseService;

    private final StringEncryptor stringEncryptor;

    @Value("${open-ai.api-key}")
    private String openaiKey;

    @GetMapping("/{userId}")
    @ResponseBody
    private ResponseEntity findPhrase(@PathVariable String userId, @RequestParam LocalDate date) {

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        try {
            PhraseDto phraseDto = phraseService.findPhrase(userId, date);
            return new ResponseEntity(phraseDto, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            return new ResponseEntity(message, headers, HttpStatus.BAD_REQUEST);
        }
    }

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
    public String getTest(Model model) {
        String key = stringEncryptor.decrypt(openaiKey);
        model.addAttribute("openaiKey", key);

        return "test/test";
    }
}
