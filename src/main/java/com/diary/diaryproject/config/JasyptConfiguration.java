package com.diary.diaryproject.config;


import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.diary.diaryproject")
@EnableEncryptableProperties
public class JasyptConfiguration {

    @Value("${APP_EN}")
    private  String appEn;

    @Bean("jasyptStringEncryptor")
    @Primary
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPoolSize(5);
        config.setPassword(appEn);
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        return encryptor;
    }
}
