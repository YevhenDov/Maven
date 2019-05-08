package com.company.servce.impl;

import com.company.dao.daoimpl.UserDaoImpl;
import com.company.entity.User;
import com.company.servce.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Log4j
@Service
public class UserServiceImpl implements UserService {
    private static final String PATH_TO_FILE = "META-INF/spring/context.xml";

    private UserDaoImpl userDao;

    @PostConstruct
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext(PATH_TO_FILE);
        userDao = (UserDaoImpl) context.getBean("userDaoImpl");
        log.info("Init UserService");
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
