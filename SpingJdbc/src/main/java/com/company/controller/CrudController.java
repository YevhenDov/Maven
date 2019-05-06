package com.company.controller;

import com.company.dao.daoimpl.UserDaoImpl;
import com.company.entity.User;
import com.company.servce.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CrudController {
    UserServiceImpl userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping("/getUserById")
    public String getUserById(Model model, @RequestParam("id") int id) {
        User user = userService.getUserById(id).get();
        model.addAttribute("getById", user);
        return "userById";
    }

    @RequestMapping("/create")
    public String create(Model model, @ModelAttribute("user") User user) {
        userService.createUser(user);
        model.addAttribute("user", user);
        return "create";
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUserById(id).get());
        userService.deleteUser(id);
        return "delete";
    }

    @RequestMapping("/update")
    public String update(Model model, @ModelAttribute("user") User user, @RequestParam("id") int id) {
        model.addAttribute("user", user);
        userService.updateUser(id, user);
        return "update";
    }
}
