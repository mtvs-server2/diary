package com.diary.diaryproject.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.diary.diaryproject"})
public class DiaryProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiaryProjectApplication.class, args);
    }
}
