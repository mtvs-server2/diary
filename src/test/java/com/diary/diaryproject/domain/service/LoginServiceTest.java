package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.DiaryProjectApplication;
import com.diary.diaryproject.application.config.BeanConfiguration;
import com.diary.diaryproject.application.config.JpaConfiguration;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, DiaryProjectApplication.class, BeanConfiguration.class})
class LoginServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void login() {
        User user = userRepository.findByIdAndPwd("mymy", "1234").get();

        assertNotNull(user);
    }
}