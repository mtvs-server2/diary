package com.diary.diaryproject.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication()
@ComponentScan(basePackages = "com.diary.diaryproject")
public class DiaryProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiaryProjectApplication.class, args);
    }
}
