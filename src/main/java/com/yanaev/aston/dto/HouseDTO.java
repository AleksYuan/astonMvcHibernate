package com.yanaev.aston.dto;

import com.yanaev.aston.model.Car;
import com.yanaev.aston.model.User;

import java.util.ArrayList;
import java.util.List;

public class HouseDTO {

    private Integer area;
    private Boolean garage;
    private List<User> users = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();

    public HouseDTO() {
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Boolean getGarage() {
        return garage;
    }

    public void setGarage(Boolean garage) {
        this.garage = garage;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        if (cars == null) cars = new ArrayList<>();
        if (!cars.equals(car)) cars.add(car);
    }

    public void deleteCar(Car car) {
        if (cars == null) cars = new ArrayList<>();
        if (cars.equals(car)) cars.remove(car);
    }

    public void addUser(User user) {
        if (users == null) users = new ArrayList<>();
        if (!users.contains(user)) users.add(user);
    }

    public void deleteUser(User user) {
        if (users == null) users = new ArrayList<>();
        users.remove(user);
    }
}
