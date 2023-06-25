package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.dto.AddressDTO;
import com.diary.diaryproject.domain.dto.AddressStatic;
import com.diary.diaryproject.domain.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public String map(@RequestBody AddressDTO addr, Model model) {
        mapService.saveToRepository(addr);

        String address = addr.getAddress();
        String roadAddress = addr.getRoadAddress();

        AddressStatic.addressStatic = new AddressStatic(address, roadAddress);

        return "saveAddr";
    }

    @GetMapping("saveAddr")
    public String saveAddr(Model model) {
        model.addAttribute("address", AddressStatic.addressStatic.getAddress());
        model.addAttribute("roadAddress", AddressStatic.addressStatic.getRoadAddress());

        return "saveAddr";
    }
}
