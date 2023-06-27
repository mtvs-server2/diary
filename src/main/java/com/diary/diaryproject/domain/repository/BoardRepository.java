package com.diary.diaryproject.domain.repository;

import com.diary.diaryproject.domain.aggregate.entity.Board;
import com.diary.diaryproject.domain.aggregate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByUserAndDate(User user, LocalDate date);
}

