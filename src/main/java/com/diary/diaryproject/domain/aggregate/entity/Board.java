package com.diary.diaryproject.domain.aggregate.entity;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardNo;

    @Column
    private String title;

    @Column
    private String body;

    @Column(nullable = false)
    private EmojiEnum emoji;

    @Column(nullable = false)
    private Date date;

}
