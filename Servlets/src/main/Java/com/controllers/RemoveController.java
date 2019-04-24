package com.controllers;

import com.daoimpl.DeveloperDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/remove")
public class RemoveController extends HttpServlet {
    private DeveloperDaoImpl developerDaoImpl;

    @Override
    public void init() throws ServletException{
        developerDaoImpl = new DeveloperDaoImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{

        request.setCharacterEncoding("UTF8");
        developerDaoImpl.delete(developerDaoImpl.findById(Integer.valueOf(request.getParameter("id"))).get());

        response.sendRedirect(request.getContextPath() + "/list");
    }
}
