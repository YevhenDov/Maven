package com.development.dao;

import com.development.model.Skill;
import com.development.service.Connector;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDao {
    private static final Logger LOGGER = Logger.getLogger(SkillDao.class);
    private List<Skill> skills = new ArrayList<>();

    private final String CREATE_REQUEST = "INSERT INTO skill(skill, skill_lvl) VALUES (?, ?)";
    private final String READ_REQUEST = "SELECT * FROM developers";
    private final String UPDATE_REQUEST = "UPDATE skills SET skillLvl = middle WHERE skillLvl = ?";
    private final String DELETE_REQUEST = "DELETE FROM skills WHERE skill_id = ?";

    public void createData(Skill skill) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(CREATE_REQUEST);
            preparedStatement.setString(1, skill.getSkill());
            preparedStatement.setString(2, skill.getSkillLvl());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public List<Skill> readData() throws SQLException {
        ResultSet resultSet;

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_REQUEST)) {
            resultSet = statement.executeQuery(READ_REQUEST);
            while (resultSet.next()) {
                skills.add(new Skill(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
        return skills;
    }

    public void updateData(Skill skill) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(UPDATE_REQUEST);
            preparedStatement.setString(1, skill.getSkill());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public void deleteData(Skill skill) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(DELETE_REQUEST);
            preparedStatement.setString(1, skill.getSkill());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }
}
