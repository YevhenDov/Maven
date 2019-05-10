package com.company.service.impl;

import com.company.entity.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void createUser(User user) {
        repository.save(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return repository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsersByMonthAndDate(int month, int day) {
        return repository.findByMatchMonthAndMatchDay(month, day);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
