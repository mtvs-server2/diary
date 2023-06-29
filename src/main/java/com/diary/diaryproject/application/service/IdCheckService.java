package com.diary.diaryproject.application.service;

import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.application.dto.UserDTO;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class IdCheckService {

    private UserRepository userRepository;

    @Autowired
    public IdCheckService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isCorrectId(UserDTO userDTO, Model model) {
        if(userDTO.getId().isEmpty()) {
            String message = "아이디는 필수 입력값입니다.";
            model.addAttribute("nullId", message);
            return false;
        } else if (!userDTO.getId().matches("^[a-zA-Z0-9]{5,20}+$")) {
            String message = "아이디를 5~20자리의 영문 대소문자, 숫자로 입력해주세요";
            model.addAttribute("incorrectId", message);
            return false;
        }
        return true;
    }

    public boolean checkDuplicatedId(UserDTO userDTO, Model model) {
        List<User> userlist = userRepository.findAll();

        for (int i = 0; i < userlist.size(); i++){
            if(userlist.get(i).getId().equals(userDTO.getId())){
                model.addAttribute("errormesg","아이디가 중복입니다.");
                return false;
            }
        }
        return true;
    }

    public boolean checkNullNickName(UserDTO userDTO, Model model) {
        if(userDTO.getNickName().isEmpty()) {
            String message = "닉네임은 필수 입력값입니다.";
            model.addAttribute("nullNickName", message);
            return false;
        }
        return true;
    }
}
