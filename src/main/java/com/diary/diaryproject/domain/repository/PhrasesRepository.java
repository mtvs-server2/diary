package com.diary.diaryproject.domain.repository;

import com.diary.diaryproject.domain.aggregate.entity.Phrases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PhrasesRepository extends JpaRepository<Phrases, Integer> {

    Phrases findByIdAndDate(String userId, LocalDate date);
}
