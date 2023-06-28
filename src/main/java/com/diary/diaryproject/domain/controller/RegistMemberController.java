package com.diary.diaryproject.domain.controller;
import com.diary.diaryproject.domain.dto.UserDTO;
import com.diary.diaryproject.domain.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
@RequestMapping("/*")
public class RegistMemberController {

    private SignUpService signUpService;

    @Autowired
    public RegistMemberController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/regist")
    public String registerpage() {
        return "register";
    }

    @PostMapping("/regist")
    public String registUser(UserDTO userDTO, Model model,
                           @RequestParam(name = "pwd") String pwd,
                           @RequestParam(name = "pwd2") String pwd2, HttpServletResponse response) throws IOException {

        if(signUpService.signUp(userDTO, model, pwd, pwd2)) {
            String mesg="회원가입이 완료되었습니다.";
            alert(mesg,response);
            return "login";
        }else{
            return "register";
        }
    }
    public void alert(String notice, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script type='text/javascript'>");
        out.println("alert('"+notice+"');");
        out.println("</script>");
        out.flush();
    }
}


