package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.aggregate.entity.Address;
import com.diary.diaryproject.domain.aggregate.entity.User;
import com.diary.diaryproject.domain.dto.AddressDTO;
import com.diary.diaryproject.domain.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/jujeop")
@RequiredArgsConstructor
public class MapController {
    private final MapService mapService;


    /*
    * index.html 머지할때 @RequestMapping, @GetMapping 수정할 것
    * */

    @GetMapping("map")
    public void printMap(){}

    @PostMapping("map")
    @ResponseBody
    public ResponseEntity map(@RequestBody AddressDTO addr, HttpServletRequest request, Model model, HttpServletResponse response) throws UnsupportedEncodingException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String id = user.getId();

        AddressDTO res =  mapService.saveToRepository(addr, id);
//        Address address = mapService.loadToRepository(id);

//        return "redirect:./calendarResult?address="+"&roadAddress="+URLEncoder.encode(address.getRoadAddress(),"utf-8");
        return ResponseEntity.ok(res);
    }

    @GetMapping("/calendarResult")
    public String saveAddr(@RequestParam("address") String address, @RequestParam("roadAddress") String roadAddress, Model model) {
        model.addAttribute("roadAddress", roadAddress);

        return "calendar";
    }
}
