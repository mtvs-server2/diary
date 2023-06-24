package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.aggregate.entity.Board;
import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.domain.dto.BoardInputDTO;
import com.diary.diaryproject.domain.repository.BoardRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class EmojiPostController {

    private final BoardInputDTO boardInputDTO;
    private final BoardRepository boardRepository;

    public EmojiPostController(BoardInputDTO boardInputDTO, BoardRepository boardRepository) {
        this.boardInputDTO = boardInputDTO;
        this.boardRepository = boardRepository;
    }
    private static class Event {
        private EmojiEnum type;
        private Date start;

        public Event(EmojiEnum type, Date start) {
            this.type = type;
            this.start = start;
        }

        public EmojiEnum getType() {
            return type;
        }

        public void setType(EmojiEnum type) {
            this.type = type;
        }

        public Date getStart() {
            return start;
        }

        public void setStart(Date start) {
            this.start = start;
        }
    }

    //@RequestMapping(value = "/emojiMapping", method = RequestMethod.GET)
    @GetMapping("/calendar")
    public ResponseEntity<List<Event>> getMappingData(Model model){
//        Map<EmojiEnum, Date> emojiMap = new HashMap<>();
          List<Event> events = new ArrayList<>();

//        List<Board> boards = boardRepository.findAll();

//        for (Board board : boards) {
//            Event event = new Event(board.getEmoji(), board.getDate());
//            events.add(event);
//        }

//        emojiMap.put(EmojiEnum.HAPPY, new Date(2023-06-01));
//        emojiMap.put(EmojiEnum.HAPPY, new Date(2023-06-02));
//        emojiMap.put(EmojiEnum.HAPPY, new Date(2023-06-03));
//
//        model.addAttribute("emojiMap", emojiMap);

        events.add(new Event(EmojiEnum.HAPPY, new Date(2023-06-01)));
        events.add(new Event(EmojiEnum.HAPPY, new Date(2023-06-02)));
        events.add(new Event(EmojiEnum.HAPPY, new Date(2023-06-03)));


        return ResponseEntity.ok(events);

//        return "calendar";
    }

}
