package com.controllers;

import com.daoimpl.DeveloperDaoImpl;
import com.entity.Developer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/create")
public class CreateController extends HttpServlet {
    private DeveloperDaoImpl developerDaoImpl;
    private Developer developer;
    private List<Developer> developers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        developerDaoImpl = new DeveloperDaoImpl();
        developer = new Developer();
        developers = developerDaoImpl.findAll();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF8");
        developer.setName(request.getParameter("name"));
        developer.setAge(Integer.valueOf(request.getParameter("age")));
        developer.setSalary(Integer.valueOf(request.getParameter("salary")));
        developerDaoImpl.create(developer);
        developers = developerDaoImpl.findAll();

        response.sendRedirect(request.getContextPath() + "/list");
    }
}
