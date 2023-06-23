package com.diary.diaryproject.domain.controller;

import com.diary.diaryproject.domain.dto.AddressDTO;
import com.diary.diaryproject.domain.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/saveAddr")
    @ResponseBody
    public Object saveAddr(@RequestBody AddressDTO addr) {

        mapService.saveToRepository(addr);
        return "sucess";
    }

//    @GetMapping("result")
//    public void markMap(AddressDTO addr){
//        mapService.loadToRepository(addr);
//
//    }


}
