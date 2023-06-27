package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.aggregate.entity.Board;
import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.domain.dto.EventDTO;
import com.diary.diaryproject.domain.dto.NoDTO;
import com.diary.diaryproject.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmojiPostService {
    private final BoardRepository boardRepository;

    @Autowired
    public EmojiPostService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public List<EventDTO> getEmoji(Long id) {

        Board findBoard = boardRepository.findById(id).get();

        List<EventDTO> events = new ArrayList<>();

        if (findBoard != null) {
            EmojiEnum emoji= findBoard.getEmoji();
            LocalDate date = findBoard.getDate();

            events.add(new EventDTO(emoji, date));
        }

        return events;

    }


    @Transactional
    public List<NoDTO> getBoardNo(Long id) {

        Board findBoard = boardRepository.findById(id).get();

        List<NoDTO> boardNos = new ArrayList<>();

        if(findBoard != null) {
            Long boardNo = findBoard.getBoradNo();
            LocalDate date = findBoard.getDate();

            boardNos.add(new NoDTO(boardNo, date));
        }

        return boardNos;
    }

}
