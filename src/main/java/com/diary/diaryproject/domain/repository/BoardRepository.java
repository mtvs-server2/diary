package com.diary.diaryproject.domain.repository;

import com.diary.diaryproject.domain.aggregate.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByUserId(int userId);
}

