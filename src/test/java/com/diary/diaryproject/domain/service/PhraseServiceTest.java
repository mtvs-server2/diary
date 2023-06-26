package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.config.BeanConfiguration;
import com.diary.diaryproject.config.JpaConfiguration;
import com.diary.diaryproject.DiaryProjectApplication;
import com.diary.diaryproject.domain.aggregate.entity.Phrases;
import com.diary.diaryproject.domain.repository.PhrasesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {JpaConfiguration.class, DiaryProjectApplication.class, BeanConfiguration.class})
@SpringBootTest
class PhraseServiceTest {

    @Autowired
    private PhrasesRepository phrasesRepository;

    @Test
    void init() {}

    @Test
    void get_phrase_test() {

        String userId = "mythymetree";
        LocalDate localDate = LocalDate.parse("2023-06-26", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Phrases phrases = phrasesRepository.findByUserIdAndCreatedDate(userId, localDate);

        assertNotNull(phrases);
    }

    @Test
    @Transactional
    void insert_phrase_test() {

        Phrases phrase = Phrases.builder()
                .userId("mythymetree")
                .phrase("주접1")
                .createdDate(LocalDate.now())
                .build();

        phrasesRepository.save(phrase);

        assertEquals("주접1", phrase.getPhrase());
    }

    @Test
    void insert_phrase_unique_test() {
        try {
            Phrases phrase = Phrases.builder()
                    .userId("mythymetree")
                    .phrase("주접1")
                    .createdDate(LocalDate.now())
                    .build();

            phrasesRepository.save(phrase);
        } catch (Exception e) {
            assertThrows(Exception.class, () -> {
                throw new Exception("예외 발생");
            }, "예외가 발생하지 않았습니다.");
        }
    }

    @Test
    @Transactional
    void modify_phase_test() {

        insert_phrase_test();

        LocalDate localDate = LocalDate.parse("2023-06-26", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Phrases phrase = phrasesRepository.findByUserIdAndCreatedDate("mythymetree", localDate);

        phrase.setPhrase("myrhymetree1");
        Phrases result = phrasesRepository.save(phrase);

        assertEquals("myrhymetree1", result.getPhrase());
    }

    @Test
    @Transactional
    void delete_phrase_test() {

        insert_phrase_test();

        String userId = "mythymetree";
        LocalDate localDate = LocalDate.parse("2023-06-26", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Phrases phrases = phrasesRepository.findByUserIdAndCreatedDate(userId, localDate);

        phrasesRepository.deleteById(phrases.getPhraseNo());

        Phrases deletedPhrases = phrasesRepository.findByUserIdAndCreatedDate(userId, localDate);

        assertNull(deletedPhrases);
    }
}