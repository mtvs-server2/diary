package com.diary.diaryproject.domain.service;

import org.springframework.stereotype.Component;

@Component
public class CheckTitle {

    public void checkTitleLength(String title) {
        if (title == null)
            throw new IllegalArgumentException("내용을 제대로 입력해주세요.");

        if ((title.length() == 0) || (title.length() > 30)) {
            throw new IllegalArgumentException("내용을 제대로 입력해주세요.");
        }
    }

}
