package com.company.controller;

import com.company.entity.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@ComponentScan(basePackages = "com.company")
public class CrudController {
    @Autowired
    UserService service;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<User> users = service.getAllUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping("/add")
    public String addUserForm(Map<String, Object> model) {
        model.put("user", new User());
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        service.createUser(user);

        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editUserForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("edit_user");
        User user = service.getUserById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        service.deleteUserById(id);

        return "redirect:/";
    }
}
