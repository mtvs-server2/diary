package com.diary.diaryproject.domain.dto;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResBoardDTO {
    private Long boradNo;
    private String title;
    private String body;
    private String date;
    private EmojiEnum emoji;
    private String phrase;
    private String address;
}
