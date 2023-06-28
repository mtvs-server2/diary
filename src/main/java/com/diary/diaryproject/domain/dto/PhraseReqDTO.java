package com.diary.diaryproject.domain.dto;

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
