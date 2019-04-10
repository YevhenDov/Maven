package com.development;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUD {
    private static final Logger LOGGER = Logger.getLogger(CRUD.class);

    public void createData(String tableName, String values) {
        String request = null;
        switch (tableName) {
            case "developers": {
                request = "INSERT INTO developers(developer_name, age, gender) VALUES (" + values + ")";
                break;
            }
            case "skills": {
                request = "INSERT INTO skills(skill, skill_lvl) VALUES (" + values + ")";
                break;
            }
            case "companies": {
                request = "INSERT INTO companies(company_name, address) VALUES (" + values + ")";
                break;
            }
            case "projects": {
                request = "INSERT INTO projects(project_name, dead_line) VALUES (" + values + ")";
                break;
            }
            case "customers": {
                request = "INSERT INTO customers(customer_name, customer_location) VALUES (" + values + ")";
                break;
            }
            default: {
                LOGGER.info(new IllegalAccessException());
            }
        }

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }

}

