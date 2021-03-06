package com.company.service;


import com.company.entity.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    User getUserById(int id);

    void updateUser(User user);

    void deleteUserById(Integer id);

    List<User> getAllUsersByMonthAndDate(int month, int day);

    List<User> getAllUsers();
}
