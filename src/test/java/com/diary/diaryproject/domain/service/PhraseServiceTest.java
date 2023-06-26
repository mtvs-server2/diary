package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.config.BeanConfiguration;
import com.diary.diaryproject.config.JpaConfiguration;
import com.diary.diaryproject.domain.DiaryProjectApplication;
import com.diary.diaryproject.domain.aggregate.entity.Phrases;
import com.diary.diaryproject.domain.repository.PhrasesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {JpaConfiguration.class, DiaryProjectApplication.class, BeanConfiguration.class})
@SpringBootTest
class PhraseServiceTest {

    @Autowired
    private PhrasesRepository phrasesRepository;

    @Test
    void insert_phrase_test() {

//        Phrases phrase = Phrases.builder()
//                .phrase("주접1")
//                .emotion(1)
//                .build();
//
//        phrasesRepository.save(phrase);
//
////        phrase = phrasesRepository.findById(phrase.getPhraseNo()).get();
//
//        assertEquals("주접1", phrase.getPhrase());
    }
}