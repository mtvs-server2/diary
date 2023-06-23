package com.diary.diaryproject.application.service;

import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.service.IdCheckService;
import com.diary.diaryproject.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    private IdCheckService idCheckService;

    @Autowired
    public SignUpService(IdCheckService idCheckService) {
        this.idCheckService = idCheckService;
    }

}
