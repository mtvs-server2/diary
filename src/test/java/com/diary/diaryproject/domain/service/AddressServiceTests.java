package com.diary.diaryproject.domain.service;


import com.diary.diaryproject.DiaryProjectApplication;
import com.diary.diaryproject.application.config.BeanConfiguration;
import com.diary.diaryproject.application.config.JpaConfiguration;
import com.diary.diaryproject.domain.aggregate.entity.Address;
import com.diary.diaryproject.domain.repository.MapRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = {JpaConfiguration.class, DiaryProjectApplication.class, BeanConfiguration.class})
@SpringBootTest
public class AddressServiceTests {
    @Autowired
    private MapRepository mapRepository;

    @DisplayName("주소가 데이터베이스에 잘 저장되는지")
    @Test
    public void addressTests(){
        Address address = new Address("경기도", "미미로", "미미", LocalDate.now());
        mapRepository.save(address);

        Assertions.assertNotNull(mapRepository.findAll());
    }

    @DisplayName("주소가 저장되지 않았을 때, 예외가 발생하는지")
    @Test
    public void addressExceptionTests(){
        try {
            if (mapRepository.findAll() == null) {
                throw new RuntimeException("예외발생");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage().toString());
        }
    }
}
