package com.diary.diaryproject.domain.service;

import com.diary.diaryproject.domain.dto.UserDTO;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class RegistMemberService {
    private final UserRepository userRepository;

    @Autowired
    public RegistMemberService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            System.out.println("validKeyName = " + validKeyName);
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    public void registUser(UserDTO userDTO) {

        User user = new User(userDTO.getId(), userDTO.getPwd(), userDTO.getNickName());
        userRepository.save(user);
    }

    public boolean checkId(UserDTO userDTO) {
        List<User> userlist=userRepository.findAll();
        System.out.println("userlist = " + userlist);

        for (int i=0; i<userlist.size(); i++){
            if(userlist.get(i).getId().equals(userDTO.getId())){
                return false;
            }
        }
        return true;
    }
}
