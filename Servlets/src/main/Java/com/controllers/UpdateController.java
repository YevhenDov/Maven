package com.controllers;

import com.daoimpl.DeveloperDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private DeveloperDaoImpl developerDaoImpl;

    public void init() {
        developerDaoImpl = new DeveloperDaoImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF8");

        developerDaoImpl.update(developerDaoImpl.findById(Integer.valueOf(request.getParameter("id"))).get());

        response.sendRedirect(request.getContextPath() + "/list");
    }
}
