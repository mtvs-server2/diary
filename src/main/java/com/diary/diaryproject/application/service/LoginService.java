package com.diary.diaryproject.application.service;


import com.diary.diaryproject.domain.aggregate.entity.UserEntity;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    @Autowired
    UserEntity userEntity;

    public void logIn(String loginId, String loginPw){
        userRepository.returnDBIdPw(loginId, loginPw);
        loginUser(loginId, loginPw);
    }


}
