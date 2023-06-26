package com.diary.diaryproject.domain.repository;

import com.diary.diaryproject.domain.aggregate.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;


public interface UserRepository {
    User save(User user);       //여긴 왜 접근제어자 없음?

    Optional<User> findById(String id);
}
