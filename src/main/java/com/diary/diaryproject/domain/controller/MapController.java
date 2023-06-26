package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.aggregate.entity.Address;
import com.diary.diaryproject.domain.dto.AddressDTO;
import com.diary.diaryproject.domain.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String map(@RequestBody AddressDTO addr, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userId");

        mapService.saveToRepository(addr, id);

        return "saveAddr";
    }

    @GetMapping("saveAddr")
    public String saveAddr(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userId");

        Address address = mapService.loadToRepository(id);
        model.addAttribute("address", address.getAddress());
        model.addAttribute("roadAddress", address.getRoadAddress());

        return "saveAddr";
    }
}
