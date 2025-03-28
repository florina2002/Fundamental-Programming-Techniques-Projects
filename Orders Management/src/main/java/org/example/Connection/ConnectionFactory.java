package org.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "inica2002";
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            LOGGER.info("Connection to PostgreSQL has been established.");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Failed to load PostgreSQL JDBC driver.", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to establish connection to PostgreSQL.", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to close ResultSet.", e);
        }
    }

    public static void close(PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to close PreparedStatement.", e);
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to close Connection.", e);
        }
    }



}
