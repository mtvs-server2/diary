package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.domain.dto.*;
import com.diary.diaryproject.domain.service.PopUpService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
public class PopUpController {

    private final PopUpService popUpService;

    private final ModelMapper modelMapper;

    public PopUpController(PopUpService popUpService, ModelMapper modelMapper) {
        this.popUpService = popUpService;
        this.modelMapper = modelMapper;
    }

    // 다이어리 입력 받아서 저장
    @PostMapping("/save-board")
    public ResponseEntity<String> saveData(@ModelAttribute ReqDataDTO reqDto, HttpServletRequest request) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ResUserDTO convertedUser = modelMapper.map(user, ResUserDTO.class);
        BoardDTO boardDTO = new BoardDTO();

        LocalDate localDate = LocalDate.parse(reqDto.getDate(), DateTimeFormatter.ISO_DATE);
        boardDTO.setBody(reqDto.getBody());
        boardDTO.setTitle(reqDto.getTitle());
        boardDTO.setEmoji(reqDto.getEmoji());
        boardDTO.setDate(localDate);
        boardDTO.setUser(convertedUser);

        Integer phraseNo = reqDto.getPhraseNo();

//        System.out.println("Title: " + title);
//        System.out.println("Text: " + body);
//        System.out.println("emojiEnum = " + emojiEnum);
        // TODO : phrase 수정
//        boardDTO.setPhrase("Phrase표시 !!");

        try {

            popUpService.checkBoardLength(boardDTO);
            popUpService.saveBoard(boardDTO, phraseNo);

            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data");
        }
    }

    // 다이어리 내용 수정
    @PostMapping("/update-board")
    @ResponseBody
    public ResponseEntity updateData(@RequestParam("title") String title, @RequestParam("body") String body,
                           @RequestParam("emoji") EmojiEnum emojiEnum, @RequestParam("boardNo") Long boardNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBody(body);
        boardDTO.setTitle(title);
        boardDTO.setEmoji(emojiEnum);
        boardDTO.setBoradNo(boardNo);

        System.out.println("update controller 호출");

        try {
            popUpService.checkBoardLength(boardDTO);
            BoardDTO data = popUpService.updateBoard(boardDTO);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            String message = "실패";
            return new ResponseEntity(message, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 저장된 다이어리 가져오기
    @GetMapping("/get-board")
    @ResponseBody
    public ResponseEntity<ResBoardDTO> getBoard(@RequestParam("boardNo") Long boardNo) {
//    public ResponseEntity<BoardDTO> getBoard(Long boardNo) {
        System.out.println("get-board 호출");

        ResBoardDTO boardDTO = new ResBoardDTO();
        try {
            boardDTO = popUpService.findBoardById(boardNo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("boardDTO = " + boardDTO.getEmoji());


        return ResponseEntity.ok(boardDTO);
    }

}