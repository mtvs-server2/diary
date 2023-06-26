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

import java.time.LocalDate;
import java.util.*;

@Controller
public class EmojiPostController {

    @Autowired
    private EmojiPostService emojiPostService;


    @GetMapping("/calendar")
    public String getEvent(Model model, @RequestParam("userId")Long userId){
//            public String getEvent(Model model){

//        List<EventDTO> events = emojiPostService.getEmoji(userId);
//        List<NoDTO> boardNos = emojiPostService.getBoardNo(userId);

        List<EventDTO> events = new ArrayList<>();
        List<NoDTO> boardNos = new ArrayList<>();

        events.add(new EventDTO(EmojiEnum.HAPPY, LocalDate.now()));
        boardNos.add(new NoDTO(1L, LocalDate.now()));

        model.addAttribute("events", events);
        model.addAttribute("boardNos", boardNos);

        return "calendar";
    }

}
