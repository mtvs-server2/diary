package com.diary.diaryproject.domain.dto;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class BoardDTO {
    private Long boradNo;
    private String title;
    private String body;
    private LocalDate date;
    private EmojiEnum emoji;
    private String phrase;

}
