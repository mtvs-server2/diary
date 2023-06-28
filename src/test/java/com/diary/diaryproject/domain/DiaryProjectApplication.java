package com.diary.diaryproject.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DiaryProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiaryProjectApplication.class, args);
    }
}
