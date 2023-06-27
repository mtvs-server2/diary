package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.domain.dto.EventDTO;
import com.diary.diaryproject.domain.dto.NoDTO;
import com.diary.diaryproject.domain.service.EmojiPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;

@Controller
public class EmojiPostController {

    @Autowired
    private EmojiPostService emojiPostService;


    @GetMapping("/calendar")
    public String getEvent(Model model, HttpServletRequest request){
//            public String getEvent(Model model){
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userId");
//        Long id = (long) request.getAttribute("userId");
//
        List<EventDTO> events = emojiPostService.getEmoji(id);
        List<NoDTO> boardNos = emojiPostService.getBoardNo(id);

        model.addAttribute("events", events);
        model.addAttribute("boardNos", boardNos);

        return "calendar";
    }

}
