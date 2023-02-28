package com.yanaev.aston.dao;

import com.yanaev.aston.model.House;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HouseDAO implements AstonMvcDAO<House> {
    private final SessionFactory sessionFactory;

    public HouseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<House> getAll() {
        List<House> houses;
        Session session = sessionFactory.openSession();
        houses = session.createQuery("select e from House e").list();
        return houses;
    }

    @Override
    public Optional<House> getById(Long id) {
        House house;
        Session session = sessionFactory.openSession();
        house = session.get(House.class, id);
        if (house == null) return Optional.empty();
        return Optional.of(house);
    }

    @Override
    public void delete(House entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            entity = session.merge(entity);
            session.remove(entity);
            transaction.commit();
        }
    }

    @Override
    public void save(House entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(House entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }
}
