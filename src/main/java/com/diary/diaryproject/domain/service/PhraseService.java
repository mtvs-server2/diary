package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.aggregate.entity.Phrases;
import com.diary.diaryproject.domain.dto.PhraseDTO;
import com.diary.diaryproject.domain.dto.PhraseReqDTO;
import com.diary.diaryproject.domain.repository.PhrasesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class PhraseService {

    private final PhrasesRepository phrasesRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public PhraseDTO registPhraseToUser(String userId, PhraseReqDTO dto) throws Exception {

        LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Phrases phrases = Phrases.builder()
                .id(userId)
                .phrase(dto.getPhrase())
                .date(date)
                .build();

        phrasesRepository.save(phrases);

        PhraseDTO result =  modelMapper.map(phrases, PhraseDTO.class);

        return result;
    }

    @Transactional
    public PhraseDTO modifyPhraseToUser(String userId, String date, String phrase) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Phrases phrases = phrasesRepository.findByIdAndDate(userId, localDate);
        phrases.setPhrase(phrase);

        PhraseDTO result =  modelMapper.map(phrases, PhraseDTO.class);

        return result;
    }

    @Transactional
    public void removePhraseToUser(String userId, String date, String phrase) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Phrases phrases = phrasesRepository.findByIdAndDate(userId, localDate);

        phrasesRepository.delete(phrases);
    }

    public PhraseDTO findPhrase(String userId, String date) {
        PhraseDTO phraseDto = new PhraseDTO();

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Phrases phrases = phrasesRepository.findByIdAndDate(userId, localDate);

        if(phrases != null) phraseDto = phraseDto.toDto(phrases);

        return phraseDto;
    }
}
