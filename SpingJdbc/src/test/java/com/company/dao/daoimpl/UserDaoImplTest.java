package com.company.dao.daoimpl;

import com.company.entity.User;
import com.company.servce.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserDaoImplTest {
    User userActual;
    User userExpected;
    UserServiceImpl userService;
    final static String PATH_TO_CONTEXT = "META-INF/spring/test-context.xml";

    @Before
    public void beforeTest() {
        userActual = new User();
        userExpected = new User();
        userService = new UserServiceImpl();
    }

    @Test
    public void createUser() {
        userActual.setAge(20);
        userActual.setName("Bob");
        userService.createUser(userActual);

        User user = userService.getUserById(1).get();
        userExpected.setName(user.getName());
        userExpected.setAge(user.getAge());
        assertEquals(userExpected, userActual);
    }

    @Test
    public void getUserById() {
        userExpected.setId(1);
        userExpected.setAge(20);
        userExpected.setName("Bob");

        userActual = userService.getUserById(1).get();
        Assert.assertEquals(userExpected, userActual);
    }

    @Test
    public void updateUser() {
        userExpected.setId(1);
        userExpected.setAge(25);
        userExpected.setName("Marry");

        userService.updateUser(1, userExpected);
        userActual = userService.getUserById(1).get();

        assertEquals(userExpected, userActual);
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(1);

        assertTrue(userService.getUserById(1).get() == null);
    }
}
