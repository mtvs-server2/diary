package com.diary.diaryproject.domain.service;

import org.springframework.stereotype.Component;

@Component
public class CheckBody {

    public void checkBodyLength(String body) {
        if (body == null)
            throw new IllegalArgumentException("제목을 제대로 입력해주세요.");

        if ((body.length() == 0) || (body.length() > 500)) {
            throw new IllegalArgumentException("제목을 제대로 입력해주세요.");
        }
    }
}
