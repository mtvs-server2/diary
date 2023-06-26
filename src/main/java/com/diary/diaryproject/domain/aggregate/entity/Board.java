package com.diary.diaryproject.domain.aggregate.entity;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;

import com.diary.diaryproject.domain.dto.BoardDTO;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardNo;

    @Column
    private String title;

    @Column
    private String body;

    @Column(nullable = false)
    private EmojiEnum emoji;

    @Column(nullable = false)
    private LocalDate date;

    @Column
    private String phrase;

    @Column int userId;

    public Board() {

    }

    public Board(BoardDTO boardDTO) {
        this.title = boardDTO.getTitle();
        this.body = boardDTO.getBody();
        this.emoji = boardDTO.getEmoji();
        this.phrase = boardDTO.getPhrase();
        this.date = boardDTO.getDate();
        this.userId = boardDTO.getUserId();
    }

    public Board(Long boradNo, String title, String body, String phrase, LocalDate date, EmojiEnum emojiEnum, int userId) {
        this.boardNo = boradNo;
        this.title = title;
        this.body = body;
        this.phrase = phrase;
        this.date = date;
        this.emoji = emojiEnum;
        this.userId = userId;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getBoradNo() {
        return boardNo;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public EmojiEnum getEmoji() {
        return emoji;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPhrase() {
        return phrase;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
