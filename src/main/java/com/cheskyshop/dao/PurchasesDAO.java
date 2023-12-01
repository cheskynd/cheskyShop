package com.cheskyshop.dao;
import com.cheskyshop.models.Purchases;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchasesDAO {
    private Connection connection;

    public PurchasesDAO(Connection connection) {
        this.connection = connection;
    }


    // Insert operation
    public boolean insertPurchase(Purchases purchase) {
        try {
            String query = "INSERT INTO purchases (customerID, shoeID, electronicID, purchaseDate, quantity, totalPrice) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, purchase.getCustomerID());
            statement.setInt(2, purchase.getShoeID());
            statement.setInt(3, purchase.getElectronicID());
            statement.setObject(4, new java.sql.Timestamp(purchase.getPurchaseDate().getTime()));
            statement.setInt(5, purchase.getQuantity());
            statement.setDouble(6, purchase.getTotalPrice());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve operation by purchaseID
    public Purchases getPurchaseByID(int purchaseID) {
        try {
            String query = "SELECT * FROM purchases WHERE purchaseID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, purchaseID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Purchases(
                        resultSet.getInt("purchaseID"),
                        resultSet.getInt("customerID"),
                        resultSet.getInt("shoeID"),
                        resultSet.getInt("electronicID"),
                        resultSet.getDate("purchaseDate"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("totalPrice")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve operation for all purchases
    public List<Purchases> getAllPurchases() {
        List<Purchases> purchasesList = new ArrayList<>();
        try {
            String query = "SELECT * FROM purchases";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Purchases purchase = new Purchases(
                        resultSet.getInt("purchaseID"),
                        resultSet.getInt("customerID"),
                        resultSet.getInt("shoeID"),
                        resultSet.getInt("electronicID"),
                        resultSet.getDate("purchaseDate"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("totalPrice")
                );
                purchasesList.add(purchase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchasesList;
    }

    // Update operation
    public boolean updatePurchase(Purchases purchase) {
        try {
            String query = "UPDATE purchases SET customerID = ?, shoeID = ?, electronicID = ?, purchaseDate = ?, " +
                    "quantity = ?, totalPrice = ? WHERE purchaseID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, purchase.getCustomerID());
            statement.setInt(2, purchase.getShoeID());
            statement.setInt(3, purchase.getElectronicID());
            statement.setObject(4, new java.sql.Timestamp(purchase.getPurchaseDate().getTime()));
            statement.setInt(5, purchase.getQuantity());
            statement.setDouble(6, purchase.getTotalPrice());
            statement.setInt(7, purchase.getPurchaseID());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete operation
    public boolean deletePurchase(int purchaseID) {
        try {
            String query = "DELETE FROM purchases WHERE purchaseID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, purchaseID);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
