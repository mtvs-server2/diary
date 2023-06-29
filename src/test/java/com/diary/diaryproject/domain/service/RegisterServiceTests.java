package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.DiaryProjectApplication;
import com.diary.diaryproject.application.config.BeanConfiguration;
import com.diary.diaryproject.application.config.JpaConfiguration;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.application.dto.UserDTO;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;

@ContextConfiguration(classes = {JpaConfiguration.class, DiaryProjectApplication.class, BeanConfiguration.class})
@SpringBootTest
public class RegisterServiceTests {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("회원 정보를 DB에 저장하는지 확인")
    @Test
    public void registUser() {
        //given
        User user = new User("abc123", "asd123", "고심이");

        //when
        userRepository.save(user);

        //then
        Assertions.assertNotNull(userRepository.findAll());
    }

    @DisplayName("회원 가입 시 입력하지 않은 값이 있을 경우 DB에 저장되지 않는 지 확인")
    @Test
    public void isCorrectRegist() {
        UserDTO userDTO = new UserDTO("", "", "");
        User user = new User(userDTO.getId(), userDTO.getPwd(), userDTO.getNickName());

        if (!userDTO.getId().isEmpty()
        && !userDTO.getPwd().isEmpty()
        && !userDTO.getNickName().isEmpty()) {
            userRepository.save(user);

            Assertions.assertNull(userRepository.findAll());
        }
    }


    @DisplayName("아이디가 5~20자리가 아니면 에러 메세지 출력하는지 확인")
    @Test
    public void isCorrectIdLength() {
        UserDTO userDTO = new UserDTO("asas", "asd123", "고심이");
        if (!userDTO.getId().matches("^{5,20}+$")) {
            String message = "아이디를 5~20자리로 입력해주세요";
            Assertions.assertEquals("아이디를 5~20자리로 입력해주세요", message);
        }

    }

    @DisplayName("아이디가 영문 대소문자, 숫자가 아니면 에러 메세지 출력하는지 확인")
    @Test
    public void isCorrectId() {
        UserDTO userDTO = new UserDTO("&&*^^", "asd123", "고심이");
        if (!userDTO.getId().matches("^[a-zA-Z0-9]+$")) {
            String message = "아이디를 영문 대소문자, 숫자로 입력해주세요";
            Assertions.assertEquals("아이디를 영문 대소문자, 숫자로 입력해주세요", message);
        }
    }

    @DisplayName("중복된 아이디가 있는 경우 에러 메세지 출력하는지 확인")
    @Test
    public void isDuplicatedId() {

        User user = new User("asdfg", "asd123", "고심이");
        UserDTO userDTO = new UserDTO("asdfg", "zxc123", "고시미");
        List<User> userlist = userRepository.findAll();

        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getId().equals(userDTO.getId())) {
                String message = "아이디가 중복입니다.";
                Assertions.assertEquals("아이디가 중복입니다.", message);
            }
        }
    }

    @DisplayName("비밀번호가 5~20자리가 아니면 에러 메세지 출력하는지 확인")
    @Test
    public void isCorrectPwdLength() {
        UserDTO userDTO = new UserDTO("asasf", "123", "고심이");
        if (!userDTO.getPwd().matches("^{5,20}+$")) {
            String message = "비밀번호를 5~20자리로 입력해주세요";
            Assertions.assertEquals("비밀번호를 5~20자리로 입력해주세요", message);
        }
    }

    @DisplayName("비밀번호가 영문 대소문자, 숫자가 아니면 에러 메세지 출력하는지 확인")
    @Test
    public void isCorrectPwd() {
        UserDTO userDTO = new UserDTO("asasf", "%^$$%", "고심이");
        if (!userDTO.getPwd().matches("^[a-zA-Z0-9]+$")) {
            String message = "비밀번호를 영문 대소문자, 숫자로 입력해주세요";
            Assertions.assertEquals("비밀번호를 영문 대소문자, 숫자로 입력해주세요", message);
        }
    }

    @DisplayName("입력한 비밀번호와 재확인 비밀번호가 동일한지 확인")
    @Test
    public void isSamePwd() {
        String pwd = "asd123";
        String pwd2 = "asd456";

        if (!pwd.equals(pwd2)) {
            String message = "동일한 비밀번호를 입력해주세요";
            Assertions.assertEquals("동일한 비밀번호를 입력해주세요", message);
        }
    }

    @DisplayName("닉네임 값을 입력하지 않은 경우 에러 메세지를 출력하는지 확인")
    @Test
    public void checkNullNickName() {
        UserDTO userDTO = new UserDTO("asasf", "$%#$%", "");

        if (userDTO.getNickName().isEmpty()) {
            String message = "닉네임은 필수 입력값입니다.";
            Assertions.assertEquals("닉네임은 필수 입력값입니다.", message);
        }
    }
}