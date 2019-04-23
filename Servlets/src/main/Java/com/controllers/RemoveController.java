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

@WebServlet("/remove")
public class RemoveController extends HttpServlet {
    private final static String PATH_TO_INDEX = "/WEB-INF/view/index.jsp";
    private DeveloperDaoImpl developerDaoImpl;
    private Developer developer;
    List<Developer> developers = new ArrayList<>();

    @Override
    public void init() {
        developerDaoImpl = new DeveloperDaoImpl();
        developer = new Developer();
        developers = developerDaoImpl.getAll();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("developers", developers);
        request.getRequestDispatcher(PATH_TO_INDEX).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        request.setCharacterEncoding("UTF8");

        developerDaoImpl.delete(developerDaoImpl.findById(Integer.valueOf(request.getParameter("id"))));
        developers = developerDaoImpl.getAll();

        doGet(request, response);
    }
}
