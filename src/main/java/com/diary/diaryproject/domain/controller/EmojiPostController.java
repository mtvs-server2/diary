package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.dto.EventDTO;
import com.diary.diaryproject.domain.dto.NoDTO;
import com.diary.diaryproject.domain.service.EmojiPostService;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class EmojiPostController {

    private final EmojiPostService emojiPostService;

    private final StringEncryptor stringEncryptor;

    @Value("${open-ai.api-key}")
    private String openaiKey;


    @Autowired
    public EmojiPostController(EmojiPostService emojiPostService, StringEncryptor stringEncryptor) {
        this.emojiPostService = emojiPostService;
        this.stringEncryptor = stringEncryptor;
    }


    @GetMapping("/calendar")
    public String getEvent(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String id = user.getId();
        String key = "Bearer " + stringEncryptor.decrypt(openaiKey);

        List<EventDTO> events = emojiPostService.getEmoji(id);
        List<NoDTO> boardNos = emojiPostService.getBoardNo(id);

        model.addAttribute("events", events);
        model.addAttribute("boardNos", boardNos);
        model.addAttribute("userId", user.getId());
        model.addAttribute("nickName", user.getNickName());
        model.addAttribute("openaiKey", key);

        return "calendar";
    }

}
