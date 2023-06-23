package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.repository.PhrasesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PhraseService {

    private final PhrasesRepository phrasesRepository;

    public Map<String, Object> getPhrase() {

        return null;
    }

    public Object test() {

        return phrasesRepository.findById(1);
    }
}
