package com.diary.diaryproject.domain.dto;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NoDTO {

    private Long boardNo;
    private LocalDate date;
}