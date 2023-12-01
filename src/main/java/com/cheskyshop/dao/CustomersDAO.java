package com.cheskyshop.dao;
import com.cheskyshop.models.Customers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class CustomersDAO {
    private Connection connection;

    public CustomersDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert operation
    public boolean insertCustomer(Customers customer) {
        try {
            String query = "INSERT INTO customers (firstName, lastName, email, phone, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getAddress());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve operation by customerID
    public Customers getCustomerByID(int customerID) {
        try {
            String query = "SELECT * FROM customers WHERE customerID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, customerID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Customers(
                        resultSet.getInt("customerID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve operation for all customers
    public List<Customers> getAllCustomers() {
        List<Customers> customersList = new ArrayList<>();
        try {
            String query = "SELECT * FROM customers";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Customers customer = new Customers(
                        resultSet.getInt("customerID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                );
                customersList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customersList;
    }

    // Update operation
    public boolean updateCustomer(Customers customer) {
        try {
            String query = "UPDATE customers SET firstName = ?, lastName = ?, email = ?, phone = ?, address = ? WHERE customerID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getAddress());
            statement.setInt(6, customer.getCustomerID());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete operation
    public boolean deleteCustomer(int customerID) {
        try {
            String query = "DELETE FROM customers WHERE customerID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, customerID);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
