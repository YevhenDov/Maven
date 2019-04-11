package com.development.dao;

import com.development.model.Project;
import com.development.service.Connector;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    private static final Logger LOGGER = Logger.getLogger(ProjectDao.class);
    private List<Project> projects = new ArrayList<>();

    public void createData(String values) {
        final String REQUEST = "INSERT INTO projects(developer_name, age, gender) VALUES (" + values + ")";

        execute(REQUEST);
    }

    public List<Project> readData() throws SQLException {
        ResultSet resultSet;
        final String REQUEST = "SELECT * FROM developers";

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(REQUEST)) {
            resultSet = statement.executeQuery(REQUEST);
            while (resultSet.next()) {
                projects.add(new Project(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return projects;
    }

    public void updateData(String column, String value, String condition) {
        final String REQUEST = "UPDATE projects SET " + column + " = " + value + " WHERE " + condition;

        execute(REQUEST);
    }

    public void deleteData(int id) {
        final String REQUEST = "DELETE FROM projects WHERE project_id = " + id;

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
