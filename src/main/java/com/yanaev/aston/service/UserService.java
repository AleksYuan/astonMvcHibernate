package com.yanaev.aston.service;

import com.yanaev.aston.dao.UserDAO;
import com.yanaev.aston.model.Car;
import com.yanaev.aston.model.House;
import com.yanaev.aston.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsersFromRepo() {
        return userDAO.getAll();
    }


    public User getUserByIdFromRepo(Long id) {
        Optional<User> user = userDAO.getById(id);
        return user.orElse(null);
    }

    public void saveUserInRepo(User user) {
        userDAO.save(user);
    }

    public void deleteUserByIdFromRepo(Long id) {
        User user = getUserByIdFromRepo(id);
        if (user != null) userDAO.delete(user);
    }

    public void updateUserInRepo(Long id, User user) {
        User current = getUserByIdFromRepo(id);
        if (current != null) {
            user.setId(id);
            userDAO.update(user);
        }
    }

    public void addHouseToUser(Long idu, House house) {
        User user = getUserByIdFromRepo(idu);
        List<House> houses = user.getHouses();
        if (!houses.contains(house)) {
            houses.add(house);
            user.setHouses(houses);
            updateUserInRepo(idu, user);
        }
    }

    public void addCarToUser(Long idu, Car car) {
        User user = getUserByIdFromRepo(idu);
        List<Car> cars = user.getCars();
        if (!cars.contains(car)) {
            cars.add(car);
            user.setCars(cars);
            updateUserInRepo(idu, user);
        }
    }
}
