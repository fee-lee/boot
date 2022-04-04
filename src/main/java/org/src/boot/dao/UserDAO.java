package org.src.boot.dao;

import org.src.boot.model.User;

import java.util.List;

public interface UserDAO {

    void saveUsers(User user);

    void updateUser(User user);

    List<User> getAllUsers();

    void deleteByIdUsers(long id);

    User findById(long id);
}
