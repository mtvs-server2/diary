package com.diary.diaryproject.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckBodyTests {
    private CheckBody checkBody;

    @BeforeEach
    public void setUp() {
        this.checkBody = new CheckBody();
    }

    @DisplayName("Pass : 본문 길이 확인")
    @Test
    public void textLength() {
        StringBuilder sb = new StringBuilder();
        sb.append("d".repeat(500));

        Assertions.assertDoesNotThrow(() -> checkBody.checkBodyLength(sb.toString()));
    }

    @DisplayName("Error : 본문 길이 확인")
    @Test
    public void textLengthError() {
        StringBuilder sb = new StringBuilder();
        sb.append("d".repeat(501));

        Assertions.assertThrows(IllegalArgumentException.class, () -> checkBody.checkBodyLength(sb.toString()));
    }

    @DisplayName("Error : 본문 길이 확인(null Exception)")
    @Test
    public void textnullError() {
        String str = null;

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> checkBody.checkBodyLength(str));
    }
}
