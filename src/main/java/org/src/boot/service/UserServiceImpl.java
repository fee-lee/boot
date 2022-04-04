package org.src.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.src.boot.dao.UserDAO;
import org.src.boot.dao.UserRepository;
import org.src.boot.model.User;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void saveUsers(User user) {
        userDAO.saveUsers(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void deleteByIdUsers(long id) {
        userDAO.deleteByIdUsers(id);
    }

    @Override
    public User findById(long id) {
        return userDAO.findById(id);
    }
}
