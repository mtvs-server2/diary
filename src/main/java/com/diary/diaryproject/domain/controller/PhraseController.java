package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.dto.PhraseDTO;
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

@RequiredArgsConstructor
@Controller
@RequestMapping("/phrases")
public class PhraseController {

    private final PhraseService phraseService;

    private final StringEncryptor stringEncryptor;

    @Value("${open-ai.api-key}")
    private String openaiKey;

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return headers;
    }

    @GetMapping("/{userId}")
    @ResponseBody
    private ResponseEntity findPhrase(@PathVariable String userId, @RequestParam String date) {

        HttpHeaders headers = getHeader();

        try {
            PhraseDTO phraseDto = phraseService.findPhrase(userId, date);
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

        HttpHeaders headers = getHeader();

        try {
            phraseService.registPhraseToUser(userId, phrase);
            return new ResponseEntity(headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            return new ResponseEntity(message, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{userId}")
    @ResponseBody
    public ResponseEntity modifyPhrase(@PathVariable String userId,
                                       @RequestParam String date,
                                       @RequestBody String phrase) {

        HttpHeaders headers = getHeader();

        try {
            phraseService.modifyPhraseToUser(userId, date, phrase);
            return new ResponseEntity(headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            return new ResponseEntity(message, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity removePhrase(@PathVariable String userId,
                                       @RequestParam String date,
                                       @RequestBody String phrase) {

        HttpHeaders headers = getHeader();

        try {
            phraseService.removePhraseToUser(userId, date, phrase);
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
