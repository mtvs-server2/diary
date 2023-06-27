package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.aggregate.entity.Phrases;
import com.diary.diaryproject.domain.dto.PhraseDto;
import com.diary.diaryproject.domain.repository.PhrasesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PhraseService {

    private final PhrasesRepository phrasesRepository;

    @Transactional
    public void registPhraseToUser(String userId, String phrase) throws Exception {

        Phrases phrases = Phrases.builder()
                .id(userId)
                .phrase(phrase)
                .date(LocalDate.now())
                .build();

        phrasesRepository.save(phrases);
    }

    @Transactional
    public void modifyPhraseToUser(String userId, String date, String phrase) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Phrases phrases = phrasesRepository.findByIdAndDate(userId, localDate);

        phrases.setPhrase(phrase);
    }

    @Transactional
    public void removePhraseToUser(String userId, String date, String phrase) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Phrases phrases = phrasesRepository.findByIdAndDate(userId, localDate);

        phrasesRepository.delete(phrases);
    }

    public PhraseDto findPhrase(String userId, String date) {
        PhraseDto phraseDto = new PhraseDto();

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Phrases phrases = phrasesRepository.findByIdAndDate(userId, localDate);

        if(phrases != null) phraseDto = phraseDto.toDto(phrases);

        return phraseDto;
    }
}
