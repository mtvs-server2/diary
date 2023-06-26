package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.dto.UserDTO;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class RegistMemberService {
    private final UserRepository userRepository;

    @Autowired
    public RegistMemberService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registUser(UserDTO userDTO) {

        User user = new User(userDTO.getId(), userDTO.getPwd(), userDTO.getNickName());
        userRepository.save(user);      //user repo, jpa repo중에서 어디 save메소드를 갖고오는지?
    }
}
