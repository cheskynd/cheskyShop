package com.cheskyshop.dao;
import com.cheskyshop.models.Shoe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoeDAO {
    private Connection connection;

    public ShoeDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert operation
    public boolean insertShoe(Shoe shoe) {
        try {
            String query = "INSERT INTO shoe (size, brand, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, shoe.getSize());
            statement.setString(2, shoe.getBrand());
            statement.setDouble(3, shoe.getPrice());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    shoe.setShoeID(generatedKeys.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve operation by shoeID
    public Shoe getShoeByID(int shoeID) {
        try {
            String query = "SELECT * FROM shoe WHERE shoeID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, shoeID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Shoe(
                        resultSet.getInt("shoeID"),
                        resultSet.getInt("size"),
                        resultSet.getString("brand"),
                        resultSet.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve operation for all shoes
    public List<Shoe> getAllShoes() {
        List<Shoe> shoesList = new ArrayList<>();
        try {
            String query = "SELECT * FROM shoe";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Shoe shoe = new Shoe(
                        resultSet.getInt("shoeID"),
                        resultSet.getInt("size"),
                        resultSet.getString("brand"),
                        resultSet.getDouble("price")
                );
                shoesList.add(shoe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoesList;
    }

    // Update operation
    public boolean updateShoe(Shoe shoe) {
        try {
            String query = "UPDATE shoe SET size = ?, brand = ?, price = ? WHERE shoeID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, shoe.getSize());
            statement.setString(2, shoe.getBrand());
            statement.setDouble(3, shoe.getPrice());
            statement.setInt(4, shoe.getShoeID());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete operation
    public boolean deleteShoe(int shoeID) {
        try {
            String query = "DELETE FROM shoe WHERE shoeID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, shoeID);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
