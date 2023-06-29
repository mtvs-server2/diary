package com.diary.diaryproject.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhraseReqDTO {
    private String phrase;
    private String date;
}
