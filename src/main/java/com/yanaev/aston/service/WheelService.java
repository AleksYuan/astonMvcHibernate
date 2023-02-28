package com.yanaev.aston.service;


import com.yanaev.aston.dao.WheelDAO;
import com.yanaev.aston.model.Wheel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WheelService {

    private final WheelDAO wheelDAO;

    public WheelService(WheelDAO wheelDAO) {
        this.wheelDAO = wheelDAO;
    }

    public List<Wheel> getAllWheelsFromRepo() {
        return wheelDAO.getAll();
    }

    public Wheel getWheelByIdFromRepo(Long id) {
        Optional<Wheel> wheel = wheelDAO.getById(id);
        return wheel.orElse(null);
    }

    public void saveWheelInRepo(Wheel wheel) {
        wheelDAO.save(wheel);
    }

    public void deleteWheelByIdFromRepo(Long id) {
        Wheel wheel = getWheelByIdFromRepo(id);
        if (wheel != null) wheelDAO.delete(wheel);
    }

    public void updateWheelInRepo(Long id, Wheel wheel) {
        Wheel current = getWheelByIdFromRepo(id);
        if (current != null) {
            wheel.setId(id);
            wheelDAO.update(wheel);
        }
    }
}
