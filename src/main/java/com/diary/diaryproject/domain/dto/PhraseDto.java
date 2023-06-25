package com.diary.diaryproject.domain.dto;

import com.diary.diaryproject.domain.aggregate.entity.Phrases;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PhraseDto {
    private Integer phraseNo;
    private String userId;
    private String phrase;
    private LocalDate createdDate;

    public PhraseDto toDto(Phrases phrases) {
        return PhraseDto.builder()
                .phraseNo(phrases.getPhraseNo())
                .userId(phrases.getUserId())
                .phrase(phrases.getPhrase())
                .createdDate(phrases.getCreatedDate())
                .build();
    }
}
