package com.diary.diaryproject.domain.service;

// 로그인과 관련된 비즈니스 로직을 처리하는 서비스 클래스이다.
// loginController에서 호출되어 사용자 인증을 수행할 것!
// DB와의 통신을 이용해서 사용자 인증을 수행하는 로직을 구현해야한다.
// LoginService 클래스를 스프링의 서비스(비즈니스로직) Bean으로 등록


import com.diary.diaryproject.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {
    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(HttpServletRequest request, String username, String password) {
        boolean isAuthenticated = userRepository.certifyUser(username, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
        }

        return isAuthenticated;
    }
}
