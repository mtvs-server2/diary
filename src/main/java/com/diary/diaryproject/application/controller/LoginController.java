package com.diary.diaryproject.application.controller;

import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 사용자의 로그인 요청을 처리하는 컨트롤러 클래스
// 세션으로 로그인을 처리해야 하니, HttpServlet을 이용한다.
// 임의로 설정한 certifyUser() 메소드를 호출하여 사용자 인증을 수행한다.
// 인증에 성공 시, 세션을 생성한 후 사용자 정보를 저장하고 로그인 후 리다이렉트!

@Controller
@RequestMapping("/*")
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = {"login", "/"})
    public String login(){

        return "login";
    }

    @PostMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 사용자가 입력한 로그인 정보값을 가져온다.
        String username = request.getParameter("id");
        String password = request.getParameter("password");

        if (userRepository.findByIdAndPwd(username, password).isPresent()) {
            // 세션을 생성하고, 사용자의 정보를 저장한다.

            User user = userRepository.findByIdAndPwd(username, password).get();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);


            // 로그인 성공 시, 다른 화면으로 리다이렉트한다.
            return "redirect:/calendar";

        } else {
            // 로그인 실패 시, 초기 화면인 로그인 화면으로 돌아간다.
            return "login";
        }
    }
}