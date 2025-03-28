package org.example.DataAccess;

import org.example.Connection.ConnectionFactory;
import org.example.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DataAccessObject for performing CRUD operations on the Product table in the database.
 */
public class ProductDAO extends AbstractDAO<Product> {
    private static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());

    /**
     * Inserts a product record into the database.
     *
     * @param product the product to insert
     * @return the inserted product, or null if insertion failed
     */
    public Product insert(Product product) {
        String query = "INSERT INTO product (productid, productname, productprice, productstock) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, product.getProductid());
            statement.setString(2, product.getProductname());
            statement.setInt(3, product.getProductprice());
            statement.setInt(4, product.getProductstock());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to insert the product.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    product.setProductid(generatedId);
                    return product;
                } else {
                    throw new SQLException("Failed to retrieve the generated ID.");
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to insert the product: " + e.getMessage());
        }
        return null;
    }

    /**
     * Finds a product by its ID.
     *
     * @param id the ID of the product to find
     * @return the found product, or null if not found
     */
    public Product findById(int id) {
        String query = "SELECT * FROM product WHERE productid = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Product product = new Product();
                    product.setProductid(resultSet.getInt("productid"));
                    product.setProductname(resultSet.getString("productname"));
                    product.setProductprice(resultSet.getInt("productprice"));
                    product.setProductstock(resultSet.getInt("productstock"));
                    return product;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to find the product: " + e.getMessage());
        }
        return null;
    }

    /**
     * Deletes a product from the database.
     *
     * @param product the product to delete
     * @return true if the product was deleted successfully, false otherwise
     */
    public boolean delete(Product product) {
        String query = "DELETE FROM product WHERE productid = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, product.getProductid());

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to delete the product: " + e.getMessage());
        }
        return false;
    }

    /**
     * Updates a product record in the database.
     *
     * @param product the product to update
     * @return the updated product, or null if update failed
     */
    public Product update(Product product) {
        String query = "UPDATE product SET productname = ?, productprice = ?, productstock = ? WHERE productid = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getProductname());
            statement.setInt(2, product.getProductprice());
            statement.setInt(3, product.getProductstock());
            statement.setInt(4, product.getProductid());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return product;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to update the product: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves all products from the database.
     *
     * @return a list of all products
     */
    public List<Product> findAll() {
        String query = "SELECT * FROM product";
        List<Product> products = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductid(resultSet.getInt("productid"));
                product.setProductname(resultSet.getString("productname"));
                product.setProductprice(resultSet.getInt("productprice"));
                product.setProductstock(resultSet.getInt("productstock"));
                products.add(product);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to retrieve products: " + e.getMessage());
        }

        return products;
    }
}
