package com.diary.diaryproject.domain.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 로그아웃과 관련된 비즈니스 로직을 처리하는 서비스 클래스
// 로그아웃 되면, 로그인 페이지로 리다이렉트 할 수 있도록 구현.

public class LogoutService {
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {

        // 기존 세션을 가져온다.
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 세션 무효화
            session.invalidate();
        }

        // 로그아웃 후, 로그인 화면으로 리다이렉트 한다.
        response.sendRedirect("login.jsp");
    }
}