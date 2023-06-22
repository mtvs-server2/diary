package com.diary.diaryproject.domain.repository;

import com.diary.diaryproject.domain.aggregate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private User user;

}
