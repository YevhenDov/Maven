package com.development.service;

import com.development.model.Developer;
import com.development.model.Company;
import com.development.model.Customer;
import com.development.model.Project;
import com.development.model.Skill;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
    private static final Logger LOGGER = Logger.getLogger(CRUD.class);

    private List<Skill> skills = new ArrayList<>();
    private List<Company> companies = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Developer> developers = new ArrayList<>();

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

    public void readData(String tableName) {
        ResultSet resultSet;
        String request = "SELECT * FROM " + tableName;

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                switch (tableName) {
                    case "developers": {
                        developers.add(new Developer(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getInt(5)
                        ));
                        break;
                    }
                    case "skills": {
                        skills.add(new Skill(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        ));
                        break;
                    }
                    case "companies": {
                        companies.add(new Company(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        ));
                        break;
                    }
                    case "projects": {
                        projects.add(new Project(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4)
                        ));
                        break;
                    }
                    case "customers": {
                        customers.add(new Customer(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        ));
                        break;
                    }
                    default: {
                        LOGGER.info(new IllegalAccessException());
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }

    public void updateData(String tableName, String column, String value, String condition) {
        String request = "UPDATE " + tableName + " SET " + column + " = " + value + " WHERE " + condition;

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }

    public void deleteData(String tableName, String condition) {
        String request = "DELETE FROM " + tableName + " WHERE " + condition;

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
