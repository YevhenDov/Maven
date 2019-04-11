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

    public void createData(Developer developer, String values) {
        final String REQUEST = "INSERT INTO developers("
                + developer.getId() + ","
                + developer.getName() + ","
                + developer.getAge() + ","
                + developer.getGender() + ","
                + developer.getSalary() + ") VALUES (" + values + ")";

        execute(REQUEST);
    }

    public List<Developer> readData() throws SQLException {
        ResultSet resultSet;
        final String REQUEST = "SELECT * FROM developers";

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(REQUEST)) {
            resultSet = statement.executeQuery(REQUEST);
            while (resultSet.next()) {
                developers.add(new Developer(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return developers;
    }

    public void updateData(String column, String value, String condition) {
        final String REQUEST = "UPDATE developers SET " + column + " = " + value + " WHERE " + condition;

        execute(REQUEST);
    }

    public void deleteData(int id) {
        final String REQUEST = "DELETE FROM developers WHERE developer_id = " + id;

        execute(REQUEST);
    }

    private void execute(String request) {
        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
