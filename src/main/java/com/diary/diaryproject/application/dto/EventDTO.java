package com.diary.diaryproject.application.dto;

import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@ToString
@Component
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private EmojiEnum type;
    private LocalDate start;
}
