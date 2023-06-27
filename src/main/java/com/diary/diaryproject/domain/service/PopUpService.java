package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.aggregate.entity.Board;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.dto.BoardDTO;
import com.diary.diaryproject.domain.dto.UserDTO;
import com.diary.diaryproject.domain.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PopUpService {
    private final CheckTitle checkTitle;
    private final CheckBody checkBody;
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PopUpService(CheckTitle checkTitle, CheckBody checkBody, BoardRepository boardRepository,
                        ModelMapper modelMapper) {
        this.checkTitle = checkTitle;
        this.checkBody = checkBody;
        this.boardRepository = boardRepository;
        this.modelMapper = modelMapper;
    }

    public void checkBoardLength(BoardDTO boardDTO) {
        checkTitle.checkTitleLength(boardDTO.getTitle());
        checkBody.checkBodyLength(boardDTO.getBody());
    }

    // 다이어리 저장
    @Transactional
    public void saveBoard(BoardDTO boardDTO) {

//       UserDTO userDto = modelMapper.map(user, UserDTO.class);
//       boardDTO.setUser(userDto);

        Board board =  modelMapper.map(boardDTO, Board.class);
        boardRepository.save(board);
    }

    // 다이어리 수정
    @Transactional
    public BoardDTO updateBoard(BoardDTO boardDTO) {
        Board board = boardRepository.findById(boardDTO.getBoradNo()).get();

        if (board != null) {
            board.setBody(boardDTO.getBody());
            board.setTitle(boardDTO.getTitle());
            board.setEmoji(boardDTO.getEmoji());
        }

        boardRepository.save(board);

        BoardDTO res = modelMapper.map(board, BoardDTO.class);

        return res;
    }

    // 다이어리 id로 조회
    @Transactional
    public BoardDTO findBoardById(Long boardId) {
        Board findBoard = boardRepository.findById(boardId).get();

        BoardDTO boardDTO = new BoardDTO();

        if(findBoard != null) {
            boardDTO.setBody(findBoard.getBody());
            boardDTO.setTitle(findBoard.getTitle());
            boardDTO.setDate(findBoard.getDate());
            boardDTO.setEmoji(findBoard.getEmoji());
        }

        return boardDTO;
    }
}
