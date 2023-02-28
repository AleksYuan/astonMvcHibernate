package com.yanaev.aston.service;

import com.yanaev.aston.dao.CarDAO;
import com.yanaev.aston.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getAllCarFromRepo() {
        return carDAO.getAll();
    }

    public Car getCarByIdFromRepo(Long id) {
        Optional<Car> car = carDAO.getById(id);
        if (car.isPresent()) return car.get();
        return null;
    }

    public void saveCarInRepo(Car car) {
        carDAO.save(car);
    }

    public void deleteCarByIdFromRepo(Long id) {
        Car car = getCarByIdFromRepo(id);
        if (car != null) carDAO.delete(car);
    }

    public void updateCarInRepo(Long id, Car car) {
        Car current = getCarByIdFromRepo(id);
        if (current != null) {
            car.setId(id);
            carDAO.update(car);
        }
    }
}
