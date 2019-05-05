package com.company.dao.daoimpl;

import com.company.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class UserDaoImplTest {
    ApplicationContext context;
    UserDaoImpl userDao;
    User userActual;
    User userExpected;

    @Before
    public void beforeTest() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/context.xml");
        userDao = (UserDaoImpl) context.getBean("userDaoImpl");
        userActual = (User) context.getBean("user");
        userExpected = (User) context.getBean("user");
    }

    @Test
    public void createUser() {
        userActual.setAge(20);
        userActual.setName("Bob");
        userDao.createUser(userActual);

        User user = userDao.getUserById(2).get();
        userExpected = (User) context.getBean("user");
        userExpected.setName(user.getName());
        userExpected.setAge(user.getAge());
        assertEquals(userExpected, userActual);
    }

    @Test
    public void getUserById() {
        userExpected.setId(2);
        userExpected.setAge(20);
        userExpected.setName("Bob");

        userActual = userDao.getUserById(2).get();
        assertEquals(userExpected, userActual);
    }

    @Test
    public void updateUser() {
        userExpected.setId(2);
        userExpected.setAge(25);
        userExpected.setName("Marry");

        userDao.updateUser(2, userExpected);
        userActual = userDao.getUserById(2).get();

        assertEquals(userExpected, userActual);
    }

    @Test
    public void deleteUser() {
        userActual.setAge(15);
        userActual.setName("John");
        userDao.createUser(userActual);

        userDao.deleteUser(3);
        userActual = userDao.getUserById(2).get();

        assertEquals(userExpected, userActual);
    }
}
