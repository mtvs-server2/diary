package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class SignUpService {    //application으로 이동해야함

    private RegistMemberService registMemberService;

    private IdCheckService idCheckService;

    private PwdCheckService pwdCheckService;

    @Autowired
    public SignUpService(RegistMemberService registMemberService, IdCheckService idCheckService, PwdCheckService pwdCheckService) {
        this.registMemberService = registMemberService;
        this.idCheckService = idCheckService;
        this.pwdCheckService = pwdCheckService;
    }

    public boolean signUp(UserDTO userDTO, Model model, String pwd, String pwd2) {
        if (idCheckService.isCorrectId(userDTO, model)
                && idCheckService.checkDuplicatedId(userDTO, model)
                && pwdCheckService.isCorrectPwd(userDTO, model)
                && pwdCheckService.isSamePwd(model, pwd, pwd2)
                && idCheckService.checkNullNickName(userDTO, model)) {
            registMemberService.registUser(userDTO, model);

            return true;
        } else {
            return false;
        }
    }
}

