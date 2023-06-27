package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.config.BeanConfiguration;
import com.diary.diaryproject.config.JpaConfiguration;
import com.diary.diaryproject.DiaryProjectApplication;
import com.diary.diaryproject.domain.aggregate.entity.Board;
import com.diary.diaryproject.domain.aggregate.entity.Phrases;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.aggregate.enumtype.EmojiEnum;
import com.diary.diaryproject.domain.repository.BoardRepository;
import com.diary.diaryproject.domain.repository.PhrasesRepository;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {JpaConfiguration.class, DiaryProjectApplication.class, BeanConfiguration.class})
@SpringBootTest
class PhraseServiceTest {

    @Autowired
    private PhrasesRepository phrasesRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void init() {}

    @Test
    void get_phrase_test() {

        String userId = "mythymetree";
        LocalDate localDate = LocalDate.parse("2023-06-26", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Phrases phrases = phrasesRepository.findByIdAndDate(userId, localDate);

        assertNotNull(phrases);
    }

    @Test
    @Transactional
    void insert_phrase_test() {

        Phrases phrase = Phrases.builder()
                .id("mythymetree")
                .phrase("주접1")
                .date(LocalDate.now())
                .build();

        phrasesRepository.save(phrase);

        assertEquals("주접1", phrase.getPhrase());
    }

    @Test
    void insert_phrase_unique_test() {
        try {
            Phrases phrase = Phrases.builder()
                    .id("mythymetree")
                    .phrase("주접1")
                    .date(LocalDate.now())
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
        Phrases phrase = phrasesRepository.findByIdAndDate("mythymetree", localDate);

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

        Phrases phrases = phrasesRepository.findByIdAndDate(userId, localDate);

        phrasesRepository.deleteById(phrases.getPhraseNo());

        Phrases deletedPhrases = phrasesRepository.findByIdAndDate(userId, localDate);

        assertNull(deletedPhrases);
    }

    @Test
    @Transactional
    void 테스트() {

        User user = new User();
        user.setId("myrhymetree");
        user.setPwd("1234");
        user.setNickName("정품");
        userRepository.save(user);

        User user1 = new User();
        if(userRepository.findById("myrhymetree").isPresent()) {
            user1 = userRepository.findById("myrhymetree").get();
        }

        Phrases phrases = new Phrases();
        phrases.setPhrase("주접주접주접");
        phrases.setId(user.getId());
        phrases.setDate(LocalDate.now());

        phrasesRepository.save(phrases);

       Board board = new Board();

       board.setTitle("다음");
       board.setBody("네이버");
       board.setDate(LocalDate.now());
       board.setPhrase(phrases);
       board.setUser(user1);

       boardRepository.save(board);

       assertEquals("주접주접주접", board.getPhrase().getPhrase());
    }
}