package org.src.boot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.src.boot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
}
