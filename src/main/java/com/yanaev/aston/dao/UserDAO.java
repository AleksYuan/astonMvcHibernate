package com.yanaev.aston.dao;


import com.yanaev.aston.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAO implements AstonMvcDAO<User> {

    private final SessionFactory sessionFactory;

    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getAll() {
        List<User> users;
        Session session = sessionFactory.openSession();
        users = session.createQuery("select e from User e").list();
        return users;
    }

    @Override
    public Optional<User> getById(Long id) {
        User user;
        Session session = sessionFactory.openSession();
        user = session.get(User.class, id);
        if (user == null) return Optional.empty();
        return Optional.of(user);
    }

    @Override
    public void delete(User entity) {
        try (Session session = sessionFactory.openSession()) {
        Transaction transaction = session.beginTransaction();
        session.remove(entity);
        transaction.commit();
        }
    }

    @Override
    public void save(User entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(User entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }
}
