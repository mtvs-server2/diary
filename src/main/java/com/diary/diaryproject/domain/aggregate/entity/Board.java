package com.diary.diaryproject.domain.aggregate.entity;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardNo;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private EmojiEnum emoji;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phaseNo")
    private Phrases phrase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressNo")
    private Address address;

    public Board() {

    }

    public Board(Long boardNo, String title, String body, Phrases phrase, LocalDate date, EmojiEnum emojiEnum, User user, Address address) {
        this.boardNo = boardNo;
        this.title = title;
        this.body = body;
        this.phrase = phrase;
        this.date = date;
        this.emoji = emojiEnum;
        this.user = user;
        this.address = address;
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

    public Long getBoardNo() {
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

    public void setBoardNo(Long boardNo) {
        this.boardNo = boardNo;
    }

    public User getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phrases getPhrase() {
        return phrase;
    }
}
