package ru.crudtoboot.springboot.repositories;

import org.springframework.stereotype.Repository;
import ru.crudtoboot.springboot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public List<User> getAllUser() {
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getById(Long id) {
        return em.find(User.class, id);
    }
}