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
import java.util.HashMap;
import java.util.Map;

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
    public Map<String, String> map(@RequestBody AddressDTO addr, HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userId");

        mapService.saveToRepository(addr, id);
        Address address = mapService.loadToRepository(id);

        model.addAttribute("address", address.getAddress());
        model.addAttribute("roadAddress", address.getRoadAddress());

        Map<String, String> data = new HashMap<>();
        data.put("address", address.getAddress());
        data.put("roadAddress", address.getRoadAddress());
        return data;
    }

    @GetMapping("saveAddr")
    public String saveAddr(@RequestBody AddressDTO addr, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userId");




        return "calendar";
    }

}
