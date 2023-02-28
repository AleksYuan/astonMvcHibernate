package com.yanaev.aston.dto;

import com.yanaev.aston.model.House;
import com.yanaev.aston.model.User;
import com.yanaev.aston.model.Wheel;

import java.util.ArrayList;
import java.util.List;

public class CarDTO {
    private String name;
    private String comment;
    private Integer createdYear;
    private House house;
    private List<User> users = new ArrayList<>();
    private List<Wheel> wheels = new ArrayList<>();

    public CarDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(Integer createdYear) {
        this.createdYear = createdYear;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public void addUser(User user) {
        if (users == null) users = new ArrayList<>();
        if (!users.contains(user)) users.add(user);
    }

    public void deleteUser(User user) {
        if (users == null) users = new ArrayList<>();
        users.remove(user);
    }


    public void addWheel(Wheel wheel) {
        if (wheels == null) wheels = new ArrayList<>();
        if (!wheels.contains(wheel)) wheels.add(wheel);
    }

    public void deleteWheel(Wheel wheel) {
        if (wheels == null) wheels = new ArrayList<>();
        wheels.remove(wheel);
    }
}
