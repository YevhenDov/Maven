package com.company.controller;

import com.company.dto.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@Controller
@ComponentScan(basePackages = "com.company")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<User> allUsers = service.getAllUsers();
        modelAndView.addObject("users", allUsers);

        return modelAndView;
    }

    @GetMapping("/add")
    public String addUserForm(Map<String, Object> model) {
        model.put("user", new User());

        return "new_user";
    }

    @PostMapping("/addOrUpdate")
    public String addOrUpdate(@ModelAttribute("user") User user) {
        service.createUser(user);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUserForm(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit_user");
        User user = service.getUserById(id);
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        service.deleteUserById(id);

        return "redirect:/";
    }
}
