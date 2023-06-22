package com.diary.diaryproject.domain.repository;

import com.diary.diaryproject.domain.aggregate.entity.Phrases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhrasesRepository extends JpaRepository<Phrases, Integer> {

}
