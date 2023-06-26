package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.domain.dto.BoardInputDTO;
import com.diary.diaryproject.domain.repository.BoardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
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
        private LocalDate start;

        private String title;

//        public LocalDate getStart() {
//            return start;
//        }
//
//        public void setStart(LocalDate start) {
//            this.start = start;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        @Override
//        public String toString() {
//            return "Event{" +
//                    "start=" + start +
//                    ", title='" + title + '\'' +
//                    '}';
//        }

        public Event(EmojiEnum type, LocalDate start) {
            this.type = type;
            this.start = start;
        }

        public EmojiEnum getType() {
            return type;
        }

        public void setType(EmojiEnum type) {
            this.type = type;
        }

        public LocalDate getStart() {
            return start;
        }

        public void setStart(LocalDate start) {
            this.start = start;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "type=" + type +
                    ", start=" + start +
                    '}';
        }
    }

    @GetMapping("/calendar")
    public String getEvent(Model model){
          List<Event> events = new ArrayList<>();


//        List<Board> boards = boardRepository.findAll();


//        for (Board board : boards) {
//            Event event = new Event(board.getEmoji(), board.getDate());
//            events.add(event);
//        }
        events.add(new Event(EmojiEnum.HAPPY, LocalDate.of(2023,6,1)));
        events.add(new Event(EmojiEnum.SMILE, LocalDate.of(2023,6,2)));
        events.add(new Event(EmojiEnum.ANGRY, LocalDate.now()));


        model.addAttribute("events", events);

        return "calendar";
    }

}
