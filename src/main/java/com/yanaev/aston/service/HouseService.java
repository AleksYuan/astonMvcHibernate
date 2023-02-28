package com.yanaev.aston.service;

import com.yanaev.aston.dao.HouseDAO;
import com.yanaev.aston.model.House;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    private final HouseDAO houseDAO;

    public HouseService(HouseDAO houseDAO) {
        this.houseDAO = houseDAO;
    }


    public List<House> getAllHousesFromRepo() {
        return houseDAO.getAll();
    }

    public House getHouseByIdFromRepo(Long id) {
        Optional<House> house = houseDAO.getById(id);
        if (house.isPresent()) return house.get();
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
