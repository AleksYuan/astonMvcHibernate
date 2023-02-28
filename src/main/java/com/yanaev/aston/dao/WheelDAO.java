package com.yanaev.aston.dao;


import com.yanaev.aston.model.Wheel;
import com.yanaev.aston.model.Wheel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class WheelDAO implements AstonMvcDAO<Wheel> {

    private final SessionFactory sessionFactory;

    public WheelDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Wheel> getAll() {
        List<Wheel> wheels;
        Session session = sessionFactory.openSession();
        wheels = session.createQuery("select e from Wheel e").list();
        return wheels;
    }

    @Override
    public Optional<Wheel> getById(Long id) {
        Wheel wheel ;
        Session session = sessionFactory.openSession();
        wheel = session.get(Wheel.class, id);
        if (wheel == null) return Optional.empty();
        return Optional.of(wheel);
    }

    @Override
    public void delete(Wheel entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }

    @Override
    public void save(Wheel entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(Wheel entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }
}
