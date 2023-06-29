package com.diary.diaryproject.application.service;


import com.diary.diaryproject.DiaryProjectApplication;
import com.diary.diaryproject.application.config.BeanConfiguration;
import com.diary.diaryproject.application.config.JpaConfiguration;
import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.application.dto.BoardDTO;
import com.diary.diaryproject.domain.repository.BoardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;


@ContextConfiguration(classes = {JpaConfiguration.class, DiaryProjectApplication.class, BeanConfiguration.class})
@SpringBootTest
public class PopUpServiceTests {

    @Autowired
    private PopUpService popUpService;

    @Autowired
    private BoardRepository boardRepository;

    private static BoardDTO boardDTO;


    @BeforeEach
    public void setUp() {
        boardDTO = new BoardDTO();

        String title = "k".repeat(5);
        String body = "d".repeat(23);
        EmojiEnum emojiEnum = EmojiEnum.HAPPY;
        LocalDate date = LocalDate.now();

        boardDTO.setTitle(title);
        boardDTO.setBody(body);
        boardDTO.setEmoji(emojiEnum);
        boardDTO.setDate(date);
    }

    @DisplayName("Error : 제목 30자 이내로 작성")
    @Test
    public void checkTitleLength() {
        String title = "d".repeat(36);

        String body = "k".repeat(100);

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(title);
        boardDTO.setBody(body);

        Assertions.assertThrows(IllegalArgumentException.class, () -> popUpService.checkBoardLength(boardDTO));
    }

    @DisplayName("Error : 내용 500자 이내로 작성")
    @Test
    public void checkBodyLength() {
        String title = "k".repeat(12);
        String body = "d".repeat(501);

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBody(body);
        boardDTO.setTitle(title);

        Assertions.assertThrows(IllegalArgumentException.class, () -> popUpService.checkBoardLength(boardDTO));
    }

    @DisplayName("Pass : 내용 500자 이내, 제목 30자 이내로 작성")
    @Test
    public void checkTextLengthPass() {
        String title = "k".repeat(13);
        String body = "d".repeat(50);

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBody(body);
        boardDTO.setTitle(title);

        Assertions.assertDoesNotThrow(()-> popUpService.checkBoardLength(boardDTO));
    }

//    @DisplayName("Pass : board 저장 확인")
//    @Test
//    public void saveBoardTest() {
//        String title = "k".repeat(5);
//        String body = "d".repeat(23);
//        EmojiEnum emojiEnum = EmojiEnum.HAPPY;
//        LocalDate date = LocalDate.now();
//
//        BoardDTO boardDTO1 = new BoardDTO();
//
//        Integer no = 1;
//        String address = "서울시";
//
//        boardDTO1.setTitle(title);
//        boardDTO1.setBody(body);
//        boardDTO1.setEmoji(emojiEnum);
//        boardDTO1.setDate(date);
//        popUpService.saveBoard(boardDTO1, no, address);
//
//        Board board = boardRepository.findById(2L).get();
//
//        System.out.println("board = " + board.getTitle());
//        System.out.println("boardDTO.getTitle() = " + boardDTO.getTitle());
//
//        boolean test = board.getBody().equals(body) && board.getTitle().equals(title)
//                && board.getEmoji().equals(emojiEnum) && board.getDate().equals(date);
//
//        Assertions.assertTrue(test);
//    }

//    @DisplayName("Pass : board 업데이트 확인")
//    @Test
//    public void saveBoardTestError() {
//        String title = "k".repeat(5);
//        String body = "d".repeat(23);
//        EmojiEnum emojiEnum = EmojiEnum.HAPPY;
//        LocalDate date = LocalDate.now();
//        String address = "서울시";
//
//        Integer no = 1;
//
//        popUpService.saveBoard(boardDTO, no, address);
//
//        boardDTO.setTitle("dkdk");
//        boardDTO.setBoradNo(1L);
//
//        popUpService.updateBoard(boardDTO);
//
//        Board board = boardRepository.findById(1L).get();
//
//        boolean test = board.getTitle().equals("dkdk") && board.getBody().equals(body);
//
//
//        Assertions.assertTrue(test);
//    }

//    @DisplayName("Pass : BoardNo로 특정 Board 정보 조회")
//    @Test
//    public void boardFindById() {
//        boardDTO = new BoardDTO();
//
//        Integer no = 1;
//        String address = "서울시";
//        popUpService.saveBoard(boardDTO, no, address);
//        ResBoardDTO board = popUpService.findBoardById(1L);
//
//        String title = "k".repeat(5);
//        String body = "d".repeat(23);
//        EmojiEnum emojiEnum = EmojiEnum.HAPPY;
//        LocalDate date = LocalDate.now();
//
//        boolean test = board.getBody().equals(body) && board.getTitle().equals(title)
//                && board.getEmoji().equals(emojiEnum) && board.getDate().equals(date);
//
//
//        Assertions.assertTrue(test);
//    }
}