//package com.company.dao.daoimpl;
//
//import com.company.entity.User;
//import com.company.servce.impl.UserServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class UserDaoImplTest {
//    private User userActual;
//    private User userExpected;
//    private UserServiceImpl userService;
//
//    @Before
//    public void beforeTest() {
//        userActual = new User();
//        userExpected = new User();
//        userService = new UserServiceImpl();
//        userService.init();
//    }
//
//    @Test
//    public void createUser() {
//        userActual.setAge(20);
//        userActual.setName("Bob");
//        userService.createUser(userActual);
//
//        User user = userService.getUserById(1).get();
//        userExpected.setName(user.getName());
//        userExpected.setAge(user.getAge());
//        assertEquals(userExpected, userActual);
//    }
//
//    @Test
//    public void getUserById() {
//        userExpected.setId(1);
//        userExpected.setAge(20);
//        userExpected.setName("Bob");
//
//        userActual = userService.getUserById(1).get();
//        assertEquals(userExpected, userActual);
//    }
//
//    @Test
//    public void updateUser() {
//        userExpected.setId(1);
//        userExpected.setAge(25);
//        userExpected.setName("Marry");
//
//        userService.updateUser(1, userExpected);
//        userActual = userService.getUserById(1).get();
//
//        assertEquals(userExpected, userActual);
//    }
//
//    @Test
//    public void deleteUser() {
//        userService.deleteUser(1);
//
//        assertTrue(userService.getUserById(1).get() == null);
//    }
//}
