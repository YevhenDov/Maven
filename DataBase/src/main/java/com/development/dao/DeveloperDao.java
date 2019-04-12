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

    private final String CREATE_REQUEST = "INSERT INTO developers(developer_name, age, gender, salary) VALUES (?, ?, ?, ?)";
    private final String READ_REQUEST = "SELECT * FROM developers";
    private final String UPDATE_REQUEST = "UPDATE developers SET salary = 2000 WHERE age = ?";
    private final String DELETE_REQUEST = "DELETE FROM developers WHERE developer_name = ?";

    public void createData(Developer developer) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(CREATE_REQUEST);
            preparedStatement.setString(1, developer.getName());
            preparedStatement.setString(2, developer.getAge());
            preparedStatement.setString(3, developer.getGender());
            preparedStatement.setInt(4, developer.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public List<Developer> readData() throws SQLException {
        ResultSet resultSet;

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_REQUEST)) {
            resultSet = statement.executeQuery(READ_REQUEST);
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
        }
        finally {
            connection.close();
        }
        return developers;
    }

    public void updateData(Developer developer) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(UPDATE_REQUEST);
            preparedStatement.setString(1, developer.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public void deleteData(Developer developer) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(DELETE_REQUEST);
            preparedStatement.setString(1, developer.getName());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }
}
