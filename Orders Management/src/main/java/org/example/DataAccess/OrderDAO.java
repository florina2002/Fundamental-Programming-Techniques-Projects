package org.example.DataAccess;

import org.example.Connection.ConnectionFactory;
import org.example.Model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO extends AbstractDAO<Order> {
    private static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
    /**
     * Inserts a new order into the database.
     *
     * @param order The order to be inserted.
     * @return The inserted order with the generated ID.
     */
    public Order insert(Order order) {
        String query = "INSERT INTO order1 (orderid, clientid, productid, quantity) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, order.getOrderid());
            statement.setInt(2, order.getClientid());
            statement.setInt(3, order.getProductid());
            statement.setInt(4, order.getQuantity());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to insert the order.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    order.setOrderid(generatedId);
                    return order;
                } else {
                    throw new SQLException("Failed to retrieve the generated ID.");
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to insert the order: " + e.getMessage());
        }
        return null;
    }
    /**
     * Finds an order by its ID.
     *
     * @param id The ID of the order to find.
     * @return The found order, or null if not found.
     */
    public Order findById(int id) {
        String query = "SELECT * FROM order1 WHERE orderid = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Order order = new Order();
                    order.setOrderid(resultSet.getInt("orderid"));
                    order.setClientid(resultSet.getInt("clientid"));
                    order.setProductid(resultSet.getInt("productid"));
                    order.setQuantity(resultSet.getInt("quantity"));
                    return order;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to find the order: " + e.getMessage());
        }
        return null;
    }
    /**
     * Deletes an order from the database.
     *
     * @param order The order to be deleted.
     * @return True if the order was deleted successfully, false otherwise.
     */
    public boolean delete(Order order) {
        String query = "DELETE FROM order1 WHERE orderid = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, order.getOrderid());

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to delete the order: " + e.getMessage());
        }
        return false;
    }
    /**
     * Updates an existing order in the database.
     *
     * @param order The order to be updated.
     * @return The updated order if the update was successful, null otherwise.
     */
    public Order update(Order order) {
        String query = "UPDATE order1 SET clientid = ?, productid = ?, quantity = ? WHERE orderid = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, order.getClientid());
            statement.setInt(2, order.getProductid());
            statement.setInt(3, order.getQuantity());
            statement.setInt(4, order.getOrderid());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return order;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to update the order: " + e.getMessage());
        }
        return null;
    }
    /**
     * Retrieves all orders from the database.
     *
     * @return A list of all orders.
     */
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM order1";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderid(resultSet.getInt("orderid"));
                order.setClientid(resultSet.getInt("clientid"));
                order.setProductid(resultSet.getInt("productid"));
                order.setQuantity(resultSet.getInt("quantity"));
                orders.add(order);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to retrieve orders: " + e.getMessage());
        }
        return orders;
    }
}