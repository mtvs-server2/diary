package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.aggregate.entity.Board;
import com.diary.diaryproject.domain.dto.BoardDTO;
import com.diary.diaryproject.domain.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PopUpService {
    private final CheckTitle checkTitle;
    private final CheckBody checkBody;
    private final BoardRepository boardRepository;
    private BoardDTO boardDTO;

    public PopUpService(CheckTitle checkTitle, CheckBody checkBody, BoardRepository boardRepository, BoardDTO boardDTO) {
        this.checkTitle = checkTitle;
        this.checkBody = checkBody;
        this.boardRepository = boardRepository;
        this.boardDTO = boardDTO;
    }

    public void checkBoardLength(BoardDTO boardDTO) {
        checkTitle.checkTitleLength(boardDTO.getTitle());
        checkBody.checkBodyLength(boardDTO.getBody());
    }

    public void saveBoard(BoardDTO boardDTO) {
        boardDTO.setDate(LocalDate.now());
        Board board = Board.builder()
                .title(boardDTO.getTitle())
                .body(boardDTO.getBody())
                .date(boardDTO.getDate())
                .emojiEnum(boardDTO.getEmojiEnum())
                .phrase(boardDTO.getPhrase())
                .build();

        boardRepository.save(board);
    }

    // 다이어리 수정
    public void updateBoard(BoardDTO boardDTO) {
        // TODO : 추후 boardNO 호출로 변경
//        Optional<Board> optionalBoard = boardRepository.findById(boardDTO.getBoradNo());
        Optional<Board> optionalBoard = boardRepository.findById(1L);
        Board board = optionalBoard.get();

        board.update(boardDTO);

        boardRepository.save(board);
    }

    // 다이어리 id로 조회
    public BoardDTO findBioardById(Long boardId) {
        Optional<Board> findBoard = boardRepository.findById(boardId);

        boardDTO.setBody(findBoard.get().getBody());
        boardDTO.setTitle(findBoard.get().getTitle());
        boardDTO.setDate(findBoard.get().getDate());
        boardDTO.setEmojiEnum(findBoard.get().getEmojiEnum());

        return boardDTO;
    }

}
