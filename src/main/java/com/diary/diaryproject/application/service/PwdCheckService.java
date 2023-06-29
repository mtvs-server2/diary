package com.diary.diaryproject.application.service;

import com.diary.diaryproject.application.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class PwdCheckService {


    public boolean isCorrectPwd(UserDTO userDTO, Model model) {
        if(userDTO.getPwd().isEmpty()) {
            String message = "비밀번호는 필수 입력값입니다.";
            model.addAttribute("nullPwd", message);
            return false;
        } else if (!userDTO.getPwd().matches("^[a-zA-Z0-9]{5,20}+$")) {
            String message = "비밀번호를 5~20자리의 영문 대소문자, 숫자로 입력해주세요";
            model.addAttribute("incorrectPwd", message);
            return false;
        }
        return true;
    }

    public boolean isSamePwd(Model model, String pwd, String pwd2) {
        if (!pwd.equals(pwd2)) {
            String message = "동일한 비밀번호를 입력해주세요";
            model.addAttribute("notSamePwd", message);
            return false;
        }
            return true;
    }
}
