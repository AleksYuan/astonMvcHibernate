package com.yanaev.aston.dto;


import com.yanaev.aston.model.Car;
import com.yanaev.aston.model.House;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;
    private List<House> houses;

    private List<Car> cars;

    public UserDTO() {
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addCar(Car car) {
        if (cars == null) cars = new ArrayList<>();
        if (!cars.equals(car)) cars.add(car);
    }

    public void deleteCar(Car car) {
        if (cars == null) cars = new ArrayList<>();
        if (cars.equals(car)) cars.remove(car);
    }

    public void addHouse(House house) {
        if (houses == null) cars = new ArrayList<>();
        if (!houses.equals(house)) houses.add(house);
    }

    public void deleteHouse(House house) {
        if (houses == null) cars = new ArrayList<>();
        if (houses.equals(house)) cars.remove(house);
    }
}
