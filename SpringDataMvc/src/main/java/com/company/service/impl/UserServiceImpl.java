package com.company.service.impl;

import com.company.dto.User;
import com.company.entity.UserEntity;
import com.company.interceptor.SimpleLogger;
import com.company.repository.UserEntityRepository;
import com.company.service.UserService;
import com.company.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityRepository repository;
    @Autowired
    private UserTransformer transformer;

    @Override
    @Interceptors(SimpleLogger.class)
    public void createUser(User user) {
        repository.save(transformer.buildEntity(user));
    }

    @Override
    public User getUserById(int id) {
        return transformer.buildUser(repository.findById(id).get());
    }

    @Override
    public void updateUser(User user) {
        repository.save(transformer.buildEntity(user));
    }

    @Override
    public void deleteUserById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> allUserEntity = repository.findAll();
        List<User> allUsers = new ArrayList<>();

        for (UserEntity userEntity : allUserEntity) {
            allUsers.add(transformer.buildUser(userEntity));
        }

        return allUsers;
    }
}

