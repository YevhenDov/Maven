package com.development.dao;

import com.development.model.Developer;
import com.development.service.Connector;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDao {
    private static final Logger LOGGER = Logger.getLogger(Developer.class);
    private List<Developer> developers = new ArrayList<>();

    public void createData(String values) {
        String request;
        request = "INSERT INTO developers(developer_name, age, gender) VALUES (" + values + ")";

        Execute(request);
    }

    public void readData() {
        ResultSet resultSet;
        String request = "SELECT * FROM developers";

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                developers.add(new Developer(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(String column, String value, String condition) {
        String request = "UPDATE developers SET " + column + " = " + value + " WHERE " + condition;

        Execute(request);
    }

    public void deleteData(String condition) {
        String request = "DELETE FROM developers WHERE " + condition;

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
