package com.company.dao;

import com.company.entity.User;

import java.util.Optional;

public interface UserDao {
    void createUser(User user);

    Optional<User> getUserById(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
