package com.yanaev.aston.dto;

import com.yanaev.aston.model.Car;


public class WheelDTO {
    private String type;
    private Integer radius;
    private Car car;

    public WheelDTO() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
