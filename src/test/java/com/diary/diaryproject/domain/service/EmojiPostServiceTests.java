package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.DiaryProjectApplication;
import com.diary.diaryproject.config.BeanConfiguration;
import com.diary.diaryproject.config.JpaConfiguration;
import com.diary.diaryproject.domain.aggregate.entity.Board;
import com.diary.diaryproject.domain.aggregate.entity.Phrases;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.domain.dto.EventDTO;
import com.diary.diaryproject.domain.repository.BoardRepository;
import com.diary.diaryproject.domain.repository.PhrasesRepository;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import javax.transaction.Transactional;

import java.time.LocalDate;

import static com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum.HAPPY;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {JpaConfiguration.class, DiaryProjectApplication.class, BeanConfiguration.class})
@SpringBootTest
@Transactional
public class EmojiPostServiceTests {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("회원의 작성 날짜와 감정 이모티콘이 일치하는지 확인")
    @Test
    public void checkCorrectDateAndEmoji() {
        //given
        LocalDate date = LocalDate.now();
        EmojiEnum emoji = EmojiEnum.HAPPY;

        Board board = new Board(2L, "title", "body", null, date, emoji,null);

        boardRepository.save(board);

        Board retrievedBoard = boardRepository.findById(board.getBoardNo()).orElse(null);

        assertEquals(date, retrievedBoard.getDate());
        assertEquals(emoji, retrievedBoard.getEmoji());

    }

    @DisplayName("회원의 작성 보드 번호와 날짜가 일치하는 확인")
    @Test
    public void checkCorrectDateAndBoardNo() {
        //given
        LocalDate date = LocalDate.now();
        Long boardNo = 1L;

        Board board = new Board(boardNo, "title", "body", null, date, EmojiEnum.CRY,null);

        boardRepository.save(board);

        Board retrievedBoard = boardRepository.findById(board.getBoardNo()).orElse(null);

        assertEquals(date, retrievedBoard.getDate());
        assertEquals(boardNo,retrievedBoard.getBoardNo());

    }



}
