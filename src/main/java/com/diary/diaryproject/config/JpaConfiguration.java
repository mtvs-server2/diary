package com.diary.diaryproject.config;

//import com.diary.diaryproject.domain.repository.JpaUserRepository;
import com.diary.diaryproject.domain.repository.JpaUserRepository;
import com.diary.diaryproject.domain.repository.UserRepository;
import com.diary.diaryproject.domain.service.RegistMemberService;
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
    private DataSource dataSource;
    private EntityManager em;

    @Autowired
    public JpaConfiguration(EntityManager em) {
        this.em = em;
    }

    public JpaConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    @Bean
//    public RegistMemberService registMemberService() {
//        return new RegistMemberService(userRepository());
//    }

    @Bean
    public UserRepository userRepository() {
        return new JpaUserRepository(em);
    }
}
