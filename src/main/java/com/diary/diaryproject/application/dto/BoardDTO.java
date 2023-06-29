package com.diary.diaryproject.application.dto;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardDTO {
    private Long boradNo;
    private String title;
    private String body;
    private LocalDate date;
    private EmojiEnum emoji;
    private PhraseDTO phrase;
    private ResUserDTO user;
    private AddressDTO address;

}
