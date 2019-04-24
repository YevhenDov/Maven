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

@WebServlet("/list")
public class HomeController extends HttpServlet {
    private String PATH_TO_FILE = "WEB-INF/view/index.jsp";
    private DeveloperDaoImpl developerDaoImpl;
    private List<Developer> developers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        developerDaoImpl = new DeveloperDaoImpl();
        developers = developerDaoImpl.findAll();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("developers", developers);
        request.getRequestDispatcher(PATH_TO_FILE).forward(request, response);

        response.sendRedirect(request.getContextPath() + "/list");
    }
}
