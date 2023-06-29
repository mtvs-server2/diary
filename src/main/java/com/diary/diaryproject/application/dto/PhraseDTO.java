package com.diary.diaryproject.application.dto;

import com.diary.diaryproject.domain.aggregate.entity.Phrases;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PhraseDTO {
    private Integer phraseNo;
    private String id;
    private String phrase;
    private LocalDate date;

    public PhraseDTO toDto(Phrases phrases) {
        return PhraseDTO.builder()
                .phraseNo(phrases.getPhraseNo())
                .id(phrases.getId())
                .phrase(phrases.getPhrase())
                .date(phrases.getDate())
                .build();
    }
}
