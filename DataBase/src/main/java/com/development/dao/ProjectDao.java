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
    private static final Logger LOGGER = Logger.getLogger(SkillDao.class);
    private List<Project> projects = new ArrayList<>();

    private final String CREATE_REQUEST = "INSERT INTO projects(project_name, dead_line, cost ) VALUES (?, ?, ?)";
    private final String READ_REQUEST = "SELECT * FROM projects";
    private final String UPDATE_REQUEST = "UPDATE projects SET cost = 20000 WHERE project_name = ?";
    private final String DELETE_REQUEST = "DELETE FROM projects WHERE project_name = ?";

    public void createData(Project project) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(CREATE_REQUEST);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDeadLine());
            preparedStatement.setString(3, project.getCost());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public List<Project> readData() throws SQLException {
        ResultSet resultSet;

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_REQUEST)) {
            resultSet = statement.executeQuery(READ_REQUEST);
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
        }
        finally {
            connection.close();
        }
        return projects;
    }

    public void updateData(Project project) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(UPDATE_REQUEST);
            preparedStatement.setString(1, project.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public void deleteData(Project project) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(DELETE_REQUEST);
            preparedStatement.setString(1, project.getName());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }
}
