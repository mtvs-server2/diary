package com.diary.diaryproject.domain.dto;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Component
public class BoardInputDTO {
    private Long boardNo;
    private String title;
    private String body;
    private LocalDate date;
    private EmojiEnum emojiEnum;

}
