package com.development.service;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static final Logger LOGGER = Logger.getLogger(Connector.class);

    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/developers_base?serverTimezone=Europe/Kiev&useSSL=false";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            LOGGER.info("Driver founded.");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }
}
