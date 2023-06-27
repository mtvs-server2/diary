package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.domain.dto.BoardDTO;
import com.diary.diaryproject.domain.service.PopUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class PopUpController {

    private final PopUpService popUpService;
    private BoardDTO boardDTO;

    public PopUpController(PopUpService popUpService, BoardDTO boardDTO) {
        this.popUpService = popUpService;
        this.boardDTO = boardDTO;
    }

    // 다이어리 입력 받아서 저장
    @PostMapping("/save-board")
    public ResponseEntity<String> saveData(@RequestParam("title") String title, @RequestParam("body") String body,
                           @RequestParam("emoji") EmojiEnum emojiEnum, @RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        boardDTO.setBody(body);
        boardDTO.setTitle(title);
        boardDTO.setEmoji(emojiEnum);
        boardDTO.setDate(localDate);

        System.out.println("Title: " + title);
        System.out.println("Text: " + body);
        System.out.println("emojiEnum = " + emojiEnum);
        // TODO : phrase 수정
//        boardDTO.setPhrase("Phrase표시 !!");

        try {

            popUpService.checkBoardLength(boardDTO);
            popUpService.saveBoard(boardDTO);

            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
        }
    }

    // 다이어리 내용 수정
    @PostMapping("/update-board")
    public String updateData(@RequestParam("title") String title, @RequestParam("body") String body,
                           @RequestParam("emoji") EmojiEnum emojiEnum, @RequestParam("boardNo") Long boardNo) {
        boardDTO.setBody(body);
        boardDTO.setTitle(title);
        boardDTO.setEmoji(emojiEnum);
        boardDTO.setBoradNo(boardNo);

        System.out.println("update controller 호출");

        try {
            popUpService.checkBoardLength(boardDTO);
            popUpService.updateBoard(boardDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }

    // 저장된 다이어리 가져오기
    @GetMapping("/get-board")
    @ResponseBody
    public ResponseEntity<BoardDTO> getBoard(@RequestParam("boardNo") Long boardNo) {
//    public ResponseEntity<BoardDTO> getBoard(Long boardNo) {
        System.out.println("get-board 호출");

        try {
            boardDTO = popUpService.findBoardById(boardNo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("boardDTO = " + boardDTO.getEmoji());


        return ResponseEntity.ok(boardDTO);
    }

}