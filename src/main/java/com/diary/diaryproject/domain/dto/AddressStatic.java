package com.diary.diaryproject.domain.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressStatic {
    public static AddressStatic addressStatic;
    private String roadAddress;
    private String address;
}
