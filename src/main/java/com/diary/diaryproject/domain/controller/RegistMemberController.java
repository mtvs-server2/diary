package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.dto.UserDTO;
import com.diary.diaryproject.domain.service.RegistMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class RegistMemberController {

    private RegistMemberService registMemberService;

    @Autowired
    public RegistMemberController(RegistMemberService registMemberService) {
        this.registMemberService = registMemberService;
    }

    @GetMapping("/regist")
    public String registerpage() {
        return "register";
    }

    @PostMapping("/regist")
    public String registUser(UserDTO userDTO) {

//        user.setId(userDTO.getId());
//        user.setPwd(userDTO.getPwd());
//        user.setNickName(userDTO.getNickName());
        registMemberService.registUser(userDTO);

        return "redirect:/";
    }
}

