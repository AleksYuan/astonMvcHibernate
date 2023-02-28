package com.yanaev.aston.controller;

import com.yanaev.aston.dto.HouseDTO;
import com.yanaev.aston.model.House;
import com.yanaev.aston.service.HouseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/house")
public class HouseController {

    private final HouseService houseService;
    private final ModelMapper modelMapper;


    public HouseController(HouseService houseService, ModelMapper modelMapper) {
        this.houseService = houseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("houses", houseService.getAllHousesFromRepo());
        return "/house/all";
    }

    @GetMapping("/{id}")
    public String getOneHouse(@PathVariable("id") Long id, Model model) {
        House house = houseService.getHouseByIdFromRepo(id);
        if (house == null) return "redirect:/house/all";
        model.addAttribute("house", house);
        return "/house/one";
    }

    @GetMapping("/new")
    public String newHouse(@ModelAttribute("houseDTO") HouseDTO houseDTO) {
        return "/house/new";
    }

    @PostMapping("/new")
    public String createNewHouse(@ModelAttribute("houseDTO") HouseDTO houseDTO) {
        houseService.saveHouseInRepo(modelMapper.map(houseDTO, House.class));
        return "redirect:/house/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("idHouse", id);
        model.addAttribute("houseDTO", modelMapper.map(houseService.getHouseByIdFromRepo(id), HouseDTO.class));
        return "/house/edit";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("houseDTO") HouseDTO houseDTO,
                         @PathVariable("id") Long id) {
        houseService.updateHouseInRepo(id, modelMapper.map(houseDTO, House.class));
        return String.format("redirect:/house/%d", id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        houseService.deleteHouseByIdFromRepo(id);
        return "redirect:/house/all";
    }
}
