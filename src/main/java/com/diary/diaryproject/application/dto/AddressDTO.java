package com.diary.diaryproject.application.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressDTO {
    private Integer addressNo;
    private String roadAddress;
    private String address;
    private String date;
    private String userId;
}
