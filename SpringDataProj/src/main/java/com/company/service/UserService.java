package com.company.service;


import com.company.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);

    User getUserById(int id);

    void updateUser(User user);

    void deleteUserById(int id);

    List<User> getAllUsersByMonthAndDate(int month, int day);

    List<User> getAllUsers();
}
