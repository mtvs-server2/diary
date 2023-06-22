package com.diary.diaryproject.domain.aggregate.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Component

public class UserEntity {
    private String id;
    private String pw;
    private String name;

}
