package com.diary.diaryproject.domain.aggregate.entity;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;

import com.diary.diaryproject.domain.dto.BoardDTO;
import com.diary.diaryproject.domain.dto.UserDTO;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boradNo;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private EmojiEnum emoji;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "phaseNo")
    private Phrases phrase;

    public Board() {

    }

    public Board(BoardDTO boardDTO) {
        this.title = boardDTO.getTitle();
        this.body = boardDTO.getBody();
        this.emoji = boardDTO.getEmoji();
        this.phrase = boardDTO.getPhrase();
        this.date = boardDTO.getDate();
    }

    public Board(Long boradNo, String title, String body, Phrases phrase, LocalDate date, EmojiEnum emojiEnum) {
        this.boradNo = boradNo;
        this.title = title;
        this.body = body;
        this.phrase = phrase;
        this.date = date;
        this.emoji = emojiEnum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setEmoji(EmojiEnum emoji) {
        this.emoji = emoji;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPhrase(Phrases phrase) {
        this.phrase = phrase;
    }

    public Long getBoradNo() {
        return boradNo;
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

    public Phrases getPhrase() {
        return phrase;
    }
}
