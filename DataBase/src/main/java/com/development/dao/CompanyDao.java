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
        final String REQUEST ="INSERT INTO companies(developer_name, age, gender) VALUES (" + values + ")";

        Execute(REQUEST);
    }

    public void readData() throws SQLException {
        ResultSet resultSet;
        final String REQUEST = "SELECT * FROM developers";

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(REQUEST)) {
            resultSet = statement.executeQuery(REQUEST);
            while (resultSet.next()) {
                companies.add(new Company(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }

    public void updateData(String column, String value, String condition) {
        final String REQUEST = "UPDATE companies SET " + column + " = " + value + " WHERE " + condition;

        Execute(REQUEST);
    }

    public void deleteData(String condition) {
        final String REQUEST = "DELETE FROM companies WHERE " + condition;

        Execute(REQUEST);
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
