package com.yanaev.aston.controller;

import com.yanaev.aston.dto.CarDTO;
import com.yanaev.aston.model.Car;
import com.yanaev.aston.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    private final ModelMapper modelMapper;

    public CarController(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("cars", carService.getAllCarFromRepo());
        return "/car/all";
    }

    @GetMapping("/{id}")
    public String getOneCar(@PathVariable("id") Long id, Model model) {
        Car car = carService.getCarByIdFromRepo(id);
        if (car == null) return "redirect:/car/all";
        model.addAttribute("car", car);
        return "/car/one";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("carDTO") CarDTO carDTO) {
        return "/car/new";
    }

    @PostMapping("/new")
    public String createNewCar(@ModelAttribute("carDTO") CarDTO carDTO) {
        carService.saveCarInRepo(modelMapper.map(carDTO, Car.class));
        return "redirect:/car/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("idCar", id);
        model.addAttribute("carDTO", modelMapper.map(carService.getCarByIdFromRepo(id), CarDTO.class));
        return "/car/edit";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("carDTO") CarDTO carDTO,
                         @PathVariable("id") Long id) {
        carService.updateCarInRepo(id, modelMapper.map(carDTO, Car.class));
        return String.format("redirect:/car/%d", id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        carService.deleteCarByIdFromRepo(id);
        return "redirect:/car/all";
    }
}
