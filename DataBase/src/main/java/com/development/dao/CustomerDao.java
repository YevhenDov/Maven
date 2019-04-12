package com.development.dao;

import com.development.model.Customer;
import com.development.model.Developer;
import com.development.service.Connector;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static final Logger LOGGER = Logger.getLogger(Customer.class);
    private List<Customer> customers = new ArrayList<>();

    private final String CREATE_REQUEST = "INSERT INTO customers(customer_name, customer_location) VALUES (?, ?)";
    private final String READ_REQUEST = "SELECT * FROM customers";
    private final String UPDATE_REQUEST = "UPDATE customers SET customer_location = 'Kiev' WHERE customer_id = ?";
    private final String DELETE_REQUEST = "DELETE FROM customers WHERE customer_location = ?";

    public void createData(Customer customer) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(CREATE_REQUEST);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getLocation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public List<Customer> readData() throws SQLException {
        ResultSet resultSet;

        Connection connection = Connector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_REQUEST)) {
            resultSet = statement.executeQuery(READ_REQUEST);
            while (resultSet.next()) {
                customers.add(new Customer(
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
        return customers;
    }

    public void updateData(Customer customer) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(UPDATE_REQUEST);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }

    public void deleteData(Customer customer) throws SQLException {
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        try  {
            preparedStatement = connection.prepareStatement(DELETE_REQUEST);
            preparedStatement.setString(1, customer.getLocation());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connection.close();
        }
    }
}
