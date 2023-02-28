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
        return house.orElse(null);
    }

    public void saveHouseInRepo(House house) {
        houseDAO.save(house);
    }

    public void deleteHouseByIdFromRepo(Long id) {
        House house = getHouseByIdFromRepo(id);
        if (house != null) houseDAO.delete(house);
    }

    public void updateHouseInRepo(Long id, House house) {
        House current = getHouseByIdFromRepo(id);
        if (current != null) {
            house.setId(id);
            houseDAO.update(house);
        }
    }
}
