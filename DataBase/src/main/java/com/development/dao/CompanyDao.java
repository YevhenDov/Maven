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

    private final String CREATE_REQUEST = "INSERT INTO companies(company_name, address) VALUES (?, ?)";
    private final String READ_REQUEST = "SELECT * FROM companies_project";
    private final String UPDATE_REQUEST = "UPDATE companies SET company_name = 'Google' WHERE company_name = ?";
    private final String DELETE_REQUEST = "DELETE FROM companies WHERE company_name = ?";

    public void createData(Company company) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(CREATE_REQUEST);
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public List<Company> readData() throws SQLException {
        ResultSet resultSet;

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_REQUEST)) {
            resultSet = statement.executeQuery(READ_REQUEST);
            while (resultSet.next()) {
                companies.add(new Company(
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
        return companies;
    }

    public void updateData(Company company) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(UPDATE_REQUEST);
            preparedStatement.setString(1, company.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public void deleteData(Company company) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(DELETE_REQUEST);
            preparedStatement.setString(1, company.getName());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }
}
