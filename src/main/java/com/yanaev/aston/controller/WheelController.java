package com.yanaev.aston.controller;

import com.yanaev.aston.dto.WheelDTO;
import com.yanaev.aston.model.Wheel;
import com.yanaev.aston.service.WheelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wheel")
public class WheelController {

    private final WheelService wheelService;
    private final ModelMapper modelMapper;

    public WheelController(WheelService wheelService, ModelMapper modelMapper) {
        this.wheelService = wheelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("wheels", wheelService.getAllWheelsFromRepo());
        return "/wheel/all";
    }

    @GetMapping("/{id}")
    public String getOneWheel(@PathVariable("id") Long id, Model model) {
        Wheel wheel = wheelService.getWheelByIdFromRepo(id);
        if (wheel == null) return "redirect:/wheel/all";
        model.addAttribute("wheel", wheel);
        return "/wheel/one";
    }

    @GetMapping("/new")
    public String newWheel(@ModelAttribute("wheelDTO") WheelDTO wheelDTO) {
        return "/wheel/new";
    }

    @PostMapping("/new")
    public String createNewWheel(@ModelAttribute("wheelDTO") WheelDTO wheelDTO) {
        wheelService.saveWheelInRepo(modelMapper.map(wheelDTO, Wheel.class));
        return "redirect:/wheel/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("idWheel", id);
        model.addAttribute("wheelDTO", modelMapper.map(wheelService.getWheelByIdFromRepo(id), WheelDTO.class));
        return "/wheel/edit";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("wheelDTO") WheelDTO wheelDTO,
                         @PathVariable("id") Long id) {
        wheelService.updateWheelInRepo(id, modelMapper.map(wheelDTO, Wheel.class));
        return String.format("redirect:/wheel/%d", id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        wheelService.deleteWheelByIdFromRepo(id);
        return "redirect:/wheel/all";
    }
}
