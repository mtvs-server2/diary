package com.diary.diaryproject;

import com.diary.diaryproject.application.controller.LoginController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginTests {

    @Test
    @DisplayName("정보가 일치하지 않을 때 예외 처리 확인")
    public void notMatchedDB() throws IOException {
        // Given


        // When

        // Then

    }

    @Test
    @DisplayName("로그인에 실패했을 경우, 다시 로그인 화면으로 돌아오는지 확인")
    public void testLoginFailureRedirect() throws IOException {
        // Given
        LoginController loginController = new LoginController();
        HttpServletRequest request; // 필요한 HttpServletRequest 객체 생성
        HttpServletResponse response; // 필요한 HttpServletResponse 객체 생성
        HttpSession session = null; // 필요한 HttpSession 객체 생성

        // 세션 생성 후 로그인에 실패하도록 설정
        session.setAttribute("username", "loggedInUser");

        // When
        // 로그인 실패 시 로그인 화면으로 리다이렉트
        loginController.login(request, response, "invalidUsername", "invalidPassword");

        // Then
        // HttpServletResponse의 리다이렉트 URL을 검증하여 로그인 화면으로 리다이렉트 되었는지 확인
        Assertions.assertEquals("login.jsp", response.sendRedirect());
    }



    @Test
    @DisplayName("로그인에 성공했을 경우, 달력 화면을 출력하는지 확인")
    public void openCalendar() throws IOException {
        // Given


        // When

        // Then

    }

}