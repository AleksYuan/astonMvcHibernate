package com.yanaev.aston.controller;

import com.yanaev.aston.dto.UserDTO;
import com.yanaev.aston.model.User;
import com.yanaev.aston.service.CarService;
import com.yanaev.aston.service.HouseService;
import com.yanaev.aston.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final HouseService houseService;

    private final CarService carService;
    private final ModelMapper modelMapper;


    public UserController(UserService userService, HouseService houseService, CarService carService, ModelMapper modelMapper) {
        this.userService = userService;
        this.houseService = houseService;
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsersFromRepo());
        return "/user/all";
    }

    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserByIdFromRepo(id);
        if (user == null) return "redirect:/users/all";
        model.addAttribute("user", user);
        return "/user/one";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("userDTO") UserDTO userdto) {
        return "/user/new";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("userDTO") UserDTO userDTO) {
        userService.saveUserInRepo(modelMapper.map(userDTO, User.class));
        return "redirect:/user/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("idUser", id);
        model.addAttribute("userDTO", modelMapper.map(userService.getUserByIdFromRepo(id), UserDTO.class));
        return "/user/edit";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("userDTO") UserDTO userDTO,
                         @PathVariable("id") Long id) {
        userService.updateUserInRepo(id, modelMapper.map(userDTO, User.class));
        return String.format("redirect:/user/%d", id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUserByIdFromRepo(id);
        return "redirect:/user/all";
    }

    @PatchMapping("/{id}/add-house")
    public String addHouseToUser(@PathVariable("id") Long idu,
                                 @RequestParam("idHouse") Long idh) {
        userService.addHouseToUser(idu, houseService.getHouseByIdFromRepo(idh));
        return String.format("redirect: /user/%d", idu);
    }

    @PatchMapping("/{id}/add-car")
    public String addCarToUser(@PathVariable("id") Long idu,
                                 @RequestParam("idCar") Long idc) {
        userService.addCarToUser(idu, carService.getCarByIdFromRepo(idc));
        return String.format("redirect: /user/%d", idu);
    }


}
