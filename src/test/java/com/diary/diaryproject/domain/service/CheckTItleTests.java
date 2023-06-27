package com.diary.diaryproject.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckTItleTests {
    private CheckTitle checkTitle;

    @BeforeEach
    public void setUp() {
        this.checkTitle = new CheckTitle();
    }

    @DisplayName("Pass : 제목 길이 확인")
    @Test
    public void titleLength() {
        StringBuilder sb = new StringBuilder();
        sb.append("d".repeat(30));

        Assertions.assertDoesNotThrow(() -> checkTitle.checkTitleLength(sb.toString()));
    }

    @DisplayName("Error : 제목 길이 확인")
    @Test
    public void titleLengthError() {
        StringBuilder sb = new StringBuilder();
        sb.append("d".repeat(31));

        Assertions.assertThrows(IllegalArgumentException.class, () -> checkTitle.checkTitleLength(sb.toString()));
    }


    @DisplayName("Error : 제목 길이 확인(null Exception)")
    @Test
    public void titleNullError() {
        String str = null;

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> checkTitle.checkTitleLength(str));
    }
}
