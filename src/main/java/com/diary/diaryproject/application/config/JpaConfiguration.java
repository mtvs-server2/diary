package com.diary.diaryproject.application.config;



import com.diary.diaryproject.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
@EntityScan(basePackages = "com.diary.diaryproject")
@EnableJpaRepositories(basePackages = "com.diary.diaryproject")
public class JpaConfiguration {
}
