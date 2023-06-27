package com.diary.diaryproject.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.diary.diaryproject")
@EnableJpaRepositories(basePackages = "com.diary.diaryproject")
public class JpaConfiguration {
}
