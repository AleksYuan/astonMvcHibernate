package com.yanaev.aston.service;

import com.yanaev.aston.dao.CarDAO;
import com.yanaev.aston.model.Car;
import com.yanaev.aston.model.House;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getAllHousesFromRepo() {
        return carDAO.getAll();
    }

    public Car getCarByIdFromRepo(Long id) {
        Optional<Car> car = carDAO.getById(id);
        if (car.isPresent()) return car.get();
        return null;
    }
//
//    public void saveUserInRepo(User user) {
//        userDAO.save(user);
//    }
//
//    public void deleteUserByIdFromRepo(Long id) {
//        User user = getUserByIdFromRepo(id);
//        if (user != null) userDAO.delete(user);
//    }
//
//    public void updateUserInRepo(Long id, User user) {
//        User current = getUserByIdFromRepo(id);
//        if (current != null) {
//            user.setId(id);
//            userDAO.update(user);
//        }
//    }
}
