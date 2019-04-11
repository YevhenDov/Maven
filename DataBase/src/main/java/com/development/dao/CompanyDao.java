package com.development.dao;

import com.development.model.Company;
import com.development.service.Connector;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    private static final Logger LOGGER = Logger.getLogger(CompanyDao.class);
    private List<Company> companies = new ArrayList<>();

    public void createData(String values) {
        String request;
        request = "INSERT INTO companies(developer_name, age, gender) VALUES (" + values + ")";

        Execute(request);
    }

    public void readData() {
        ResultSet resultSet;
        String request = "SELECT * FROM developers";

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                companies.add(new Company(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(String column, String value, String condition) {
        String request = "UPDATE companies SET " + column + " = " + value + " WHERE " + condition;

        Execute(request);
    }

    public void deleteData(String condition) {
        String request = "DELETE FROM companies WHERE " + condition;

        Execute(request);
    }

    private void Execute(String request) {
        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
