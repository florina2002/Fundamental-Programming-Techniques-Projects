package org.example;

import org.example.Connection.ConnectionFactory;
import org.example.DataAccess.ClientDAO;
import org.example.Model.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Establish a database connection
        try (Connection connection = ConnectionFactory.getConnection()) {
            // Create a ClientDAO instance
            ClientDAO clientDAO = new ClientDAO();

            // Retrieve all clients
            List<Client> clients = clientDAO.findAll();

            // Print the retrieved clients
            for (Client client : clients) {
                System.out.println(client);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to connect to the database: " + e.getMessage());
        }
    }
}
