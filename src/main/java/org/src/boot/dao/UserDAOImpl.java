package org.src.boot.dao;

import org.springframework.stereotype.Repository;
import org.src.boot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUsers(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public void deleteByIdUsers(long id) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }
}
