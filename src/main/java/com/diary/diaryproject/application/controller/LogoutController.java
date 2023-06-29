package com.diary.diaryproject.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 사용자의 로그아웃 요청을 처리하는 컨트롤러 클래스.
// 사용자의 로그아웃 요청을 처리해야하니, HttpServlet을 이용한다.
// 로그인 상태에서 가지고 있는 세션을 가져와 처리한다.
// 세션을 무효화 시킴으로써 로그아웃 기능을 수행하고, 후에 리다이렉트!

@Controller
public class LogoutController {

    @GetMapping("logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws IOException {
        // HttpSession = 현재 세션를 가지고 온다.
        // getSession(false) = 세션이 존재하지 않는다면, 새로운 세션을 생성하지 않는다.
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        // 로그아웃 후에는 로그인 페이지로 다시 돌아간다.
        mv.setViewName("login");

        return mv;
    }
}