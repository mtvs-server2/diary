package com.diary.diaryproject.application.dto;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReqDataDTO {
    private String body;
    private String title;
    private EmojiEnum emoji;
    private String date;
    private Integer phraseNo;
    private Integer addressNo;
}
