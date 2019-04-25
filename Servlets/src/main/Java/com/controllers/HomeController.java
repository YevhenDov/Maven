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
    private static final String PATH_TO_FILE = "WEB-INF/view/index.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Developer> developers = new ArrayList<>();

        request.setAttribute("developers", developers);
        request.getRequestDispatcher(PATH_TO_FILE).forward(request, response);
    }
}
