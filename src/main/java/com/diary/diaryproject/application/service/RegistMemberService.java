package com.diary.diaryproject.application.service;

import com.diary.diaryproject.application.dto.UserDTO;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.transaction.Transactional;

@Component
@Transactional
public class RegistMemberService {
    private final UserRepository userRepository;

    @Autowired
    public RegistMemberService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registUser(UserDTO userDTO, Model model) {

        User user = new User(userDTO.getId(), userDTO.getPwd(), userDTO.getNickName());

        if(!userDTO.getId().equals(null)
        && !userDTO.getPwd().equals(null)
        && !userDTO.getNickName().equals(null)) {
            userRepository.save(user);
        }
    }
}
