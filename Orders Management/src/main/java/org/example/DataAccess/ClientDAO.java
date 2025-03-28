package org.example.DataAccess;

import org.example.Connection.ConnectionFactory;
import org.example.Model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DataAccessObject for performing CRUD operations on the Client table in the database.
 */
public class ClientDAO extends AbstractDAO<Client> {
    private static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    /**
     * Inserts a client record into the database.
     *
     * @param client the client to insert
     * @return the inserted client, or null if insertion failed
     */
    public Client insert(Client client) {
        String query = "INSERT INTO client (clientid, clientname, clientage, clientaddress, clientemail) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, client.getClientid());
            statement.setString(2, client.getName());
            statement.setInt(3, client.getAge());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getEmail());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to insert the client.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    client.setClientid(generatedId);
                    return client;
                } else {
                    throw new SQLException("Failed to retrieve the generated ID.");
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to insert the client: " + e.getMessage());
        }
        return null;
    }

    /**
     * Finds a client by their ID.
     *
     * @param id the ID of the client to find
     * @return the found client, or null if not found
     */
    public Client findById(int id) {
        String query = "SELECT * FROM client WHERE clientid = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Client client = new Client();
                    client.setClientid(resultSet.getInt("id"));
                    client.setName(resultSet.getString("name"));
                    client.setEmail(resultSet.getString("email"));
                    return client;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to find the client: " + e.getMessage());
        }
        return null;
    }

    /**
     * Deletes a client from the database.
     *
     * @param client the client to delete
     * @return true if the client was deleted successfully, false otherwise
     */
    public boolean delete(Client client) {
        String query = "DELETE FROM client WHERE clientid = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, client.getClientid());

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to delete the client: " + e.getMessage());
        }
        return false;
    }

    /**
     * Updates a client record in the database.
     *
     * @param client the client to update
     * @return the updated client, or null if update failed
     */
    public Client update(Client client) {
        String query = "UPDATE client SET clientname = ?, clientage = ?, clientaddress = ?, clientemail = ? WHERE clientid = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, client.getName());
            statement.setInt(2, client.getAge());
            statement.setString(3, client.getAddress());
            statement.setString(4, client.getEmail());
            statement.setInt(5, client.getClientid());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return client;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to update the client: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves all clients from the database.
     *
     * @return a list of all clients
     */
    public List<Client> findAll() {
        String query = "SELECT * FROM client";
        List<Client> clients = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Client client = new Client();
                client.setClientid(resultSet.getInt("clientid"));
                client.setName(resultSet.getString("clientname"));
                client.setAge(resultSet.getInt("clientage"));
                client.setAddress(resultSet.getString("clientaddress"));
                client.setEmail(resultSet.getString("clientemail"));
                clients.add(client);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Failed to retrieve clients: " + e.getMessage());
        }

        return clients;
    }
}
