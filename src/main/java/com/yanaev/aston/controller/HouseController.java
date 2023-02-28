package com.yanaev.aston.controller;

import com.yanaev.aston.service.HouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/house")
public class HouseController {

    private final HouseService houseService;


    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("houses", houseService.getAllHousesFromRepo());
        return "/house/all";
    }
}
