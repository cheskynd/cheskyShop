package com.cheskyshop.dao;
import com.cheskyshop.models.Electronics;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElectronicsDAO {
    private Connection connection;

    public ElectronicsDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert operation
    public boolean insertElectronic(Electronics electronic) {
        try {
            String query = "INSERT INTO electronics (brand, model, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, electronic.getBrand());
            statement.setString(2, electronic.getModel());
            statement.setDouble(3, electronic.getPrice());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve operation by electronicID
    public Electronics getElectronicByID(int electronicID) {
        try {
            String query = "SELECT * FROM electronics WHERE electronicID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, electronicID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Electronics(
                        resultSet.getInt("electronicID"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve operation for all electronics
    public List<Electronics> getAllElectronics() {
        List<Electronics> electronicsList = new ArrayList<>();
        try {
            String query = "SELECT * FROM electronics";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Electronics electronic = new Electronics(
                        resultSet.getInt("electronicID"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getDouble("price")
                );
                electronicsList.add(electronic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return electronicsList;
    }

    // Update operation
    public boolean updateElectronic(Electronics electronic) {
        try {
            String query = "UPDATE electronics SET brand = ?, model = ?, price = ? WHERE electronicID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, electronic.getBrand());
            statement.setString(2, electronic.getModel());
            statement.setDouble(3, electronic.getPrice());
            statement.setInt(4, electronic.getElectronicID());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete operation
    public boolean deleteElectronic(int electronicID) {
        try {
            String query = "DELETE FROM electronics WHERE electronicID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, electronicID);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
