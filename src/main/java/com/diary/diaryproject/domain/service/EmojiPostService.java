package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.aggregate.entity.Board;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.domain.dto.EventDTO;
import com.diary.diaryproject.domain.dto.NoDTO;
import com.diary.diaryproject.domain.repository.BoardRepository;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmojiPostService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Autowired
    public EmojiPostService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public List<EventDTO> getEmoji(Long no) {

        User user = userRepository.findById(no).get();

        List<Board> boards = boardRepository.findByUser(user);

        List<EventDTO> events = new ArrayList<>();

        for(Board board : boards) {
            EmojiEnum emoji = board.getEmoji();
            LocalDate date = board.getDate();
            events.add(new EventDTO(emoji, date));
        }

        return events;

    }


    @Transactional
    public List<NoDTO> getBoardNo(Long id) { //id는 세션으로 받기

        User user = userRepository.findById(id).get();

        List<Board> boards = boardRepository.findByUser(user);

        List<NoDTO> boardNos = new ArrayList<>();

        for(Board board : boards) {
            Long boardNo = board.getBoardNo();
            LocalDate date = board.getDate();
            boardNos.add(new NoDTO(boardNo, date));
        }

        return boardNos;
    }

}
