package org.src.boot.service;

import org.springframework.transaction.annotation.Transactional;
import org.src.boot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    @Transactional
    void saveUsers(User user);

    List<User> getAllUsers();

    @Transactional
    void deleteByIdUsers(long id);

    User findById(long id);
}
