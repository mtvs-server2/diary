package com.diary.diaryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component

public class UserDTO {
    public static UserDTO loginUser;
    private String id;
    private String pw;
    private String name;
}
