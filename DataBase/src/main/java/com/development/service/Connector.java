package com.development.service;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private static final Logger LOGGER = Logger.getLogger(Connector.class);

    public static Connection getConnection() {
        Properties properties = new Properties();
        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(".\\src\\main\\resources\\connector.properties");
            properties.load(fileInputStream);

            Class.forName(properties.getProperty("DRIVER"));
            LOGGER.info("Driver founded.");
            return DriverManager.getConnection(
                    properties.getProperty("URL"),
                    properties.getProperty("USER"),
                    properties.getProperty("PASS")
            );
        } catch (ClassNotFoundException | IOException | SQLException e) {
            LOGGER.info(e.getMessage());
            return null;
        }
    }
}

