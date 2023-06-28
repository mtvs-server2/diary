package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.dto.UserDTO;
import com.diary.diaryproject.domain.service.RegistMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

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
    public String registUser(@Valid UserDTO userDTO, Errors errors, Model model,
                             @RequestParam (name = "pwd") String pwd,
                             @RequestParam(name = "pwd2") String pwd2) {
        if (errors.hasErrors()) {
//            model.addAttribute("userDTO", userDTO); //회원가입 실패 시 입력 데이터 유지
            Map<String, String> validatorResult = RegistMemberService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            return "register";
        }

        if (!(pwd.equals(pwd2))) {
            String message = "동일한 비밀번호를 입력해주세요";
            model.addAttribute("message", message);

            return "register";
        }
        if(registMemberService.checkId(userDTO)){
            registMemberService.registUser(userDTO);
        }else{
            model.addAttribute("errormesg","아이디가 중복입니다.");
            return "register";
        }
        return "redirect:/";
    }


//    public void checkSamePwd(Model model, @RequestParam (name = "pwd") String pwd,
//                             @RequestParam(name = "pwd2") String pwd2) {
//        if (pwd != pwd2) {
//            String message = "동일한 비밀번호를 입력해주세요";
//            model.addAttribute("message", message);
//        }
//    }
}


