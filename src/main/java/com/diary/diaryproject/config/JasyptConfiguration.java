package com.diary.diaryproject.config;


import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.jasypt.encryption.StringEncryptor;

@Configuration
@ComponentScan(basePackages = "com.diary.diaryproject")
public class JasyptConfiguration {

    @Value("${APP_EN}")
    private  String appEn;

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPoolSize(5);
        config.setPassword(appEn);
        encryptor.setConfig(config);

        return encryptor;
    }
}
