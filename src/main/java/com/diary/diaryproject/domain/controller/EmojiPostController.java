package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.domain.dto.EventDTO;
import com.diary.diaryproject.domain.dto.NoDTO;
import com.diary.diaryproject.domain.service.EmojiPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class EmojiPostController {

    private final EmojiPostService emojiPostService;

    @Autowired
    public EmojiPostController(EmojiPostService emojiPostService) {
        this.emojiPostService = emojiPostService;
    }


    @GetMapping("/calendar")
    public String getEvent(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String id = user.getId();

        List<EventDTO> events = emojiPostService.getEmoji(id);
        List<NoDTO> boardNos = emojiPostService.getBoardNo(id);

        model.addAttribute("events", events);
        model.addAttribute("boardNos", boardNos);

        return "calendar";
    }

}
