package com.yanaev.aston.dao;


import com.yanaev.aston.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarDAO implements AstonMvcDAO<Car> {

    private final SessionFactory sessionFactory;

    public CarDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Car> getAll() {
        List<Car> cars;
        Session session = sessionFactory.openSession();
        cars = session.createQuery("select e from Car e").list();
        return cars;
    }

    @Override
    public Optional<Car> getById(Long id) {
        Car car ;
        Session session = sessionFactory.openSession();
        car = session.get(Car.class, id);
        if (car == null) return Optional.empty();
        return Optional.of(car);
    }

    @Override
    public void delete(Car entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }

    @Override
    public void save(Car entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(Car entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }
}
