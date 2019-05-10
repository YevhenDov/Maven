package com.company.service;


import com.company.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);

    Optional<User> getUserById(int id);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers(int month, int day);
}
