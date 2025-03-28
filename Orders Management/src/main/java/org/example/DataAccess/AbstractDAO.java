package org.example.DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.example.Connection.ConnectionFactory;

/**
 * Generic Data Access Object providing common database operations.
 *
 * @param <T> the type of the entity being accessed
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    /**
     * Constructs an AbstractDAO instance.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " = ?");
        return sb.toString();
    }

    /**
     * Retrieves all entities from the database.
     *
     * @return a list of entities
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + type.getSimpleName();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return new ArrayList<>();
    }

    /**
     * Retrieves an entity by its ID from the database.
     *
     * @param id the ID of the entity
     * @return the entity with the specified ID, or null if not found
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            List<T> objects = createObjects(resultSet);
            if (!objects.isEmpty()) {
                return objects.get(0);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<>();
        Constructor<T> ctor;
        try {
            ctor = type.getDeclaredConstructor();
            ctor.setAccessible(true);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                T instance = ctor.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(columnName);
                    if (value != null) {
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, type);
                        Method method = propertyDescriptor.getWriteMethod();
                        method.invoke(instance, value);
                    }
                }
                list.add(instance);
            }
        } catch (NoSuchMethodException | IllegalAccessException |
                 InstantiationException | InvocationTargetException |
                 SQLException | IntrospectionException e) {
            LOGGER.log(Level.SEVERE, "Failed to create objects from ResultSet.", e);
        }
        return list;
    }

    /**
     * Inserts an entity into the database.
     *
     * @param t the entity to insert
     * @return the inserted entity, or null if insertion failed
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            String insertQuery = createInsertQuery();
            statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            setStatementParameters(statement, t);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to insert the record.");
            }
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                setIdProperty(t, generatedId);
                return t;
            } else {
                throw new SQLException("Failed to retrieve the generated ID.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Updates an entity in the database.
     *
     * @param t the entity to update
     * @return the updated entity, or null if update failed
     */
    public T update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int parameterIndex = 1;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(t);
                statement.setObject(parameterIndex, value);
                parameterIndex++;
            }
            statement.executeUpdate();
            return t;
        } catch (SQLException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private String createUpdateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        List<String> fieldNames = new ArrayList<>();
        for (Field field : type.getDeclaredFields()) {
            fieldNames.add(field.getName());
        }
        for (int i = 0; i < fieldNames.size(); i++) {
            sb.append(fieldNames.get(i));
            sb.append(" = ?");
            if (i != fieldNames.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(" WHERE id = ?");
        return sb.toString();
    }

    private String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append(" (");
        Field[] fields = type.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            sb.append(field.getName());
            if (i != fields.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(") VALUES (");
        for (int i = 0; i < fields.length; i++) {
            sb.append("?");
            if (i != fields.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }


    private void setStatementParameters(PreparedStatement statement, T t) throws SQLException {
        Field[] fields = type.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(t);
            } catch (IllegalAccessException e) {
                throw new SQLException("Failed to retrieve field value for statement parameter: " + field.getName());
            }
            statement.setObject(i + 1, value);
        }
        // Set the ID value for the update query
        Field idField;
        try {
            idField = type.getDeclaredField("id");
            idField.setAccessible(true);
            Object idValue;
            try {
                idValue = idField.get(t);
            } catch (IllegalAccessException e) {
                throw new SQLException("Failed to retrieve ID field value for update statement parameter.");
            }
            statement.setObject(fields.length + 1, idValue);
        } catch (NoSuchFieldException e) {
            throw new SQLException("Failed to find ID field in class: " + type.getSimpleName());
        }
    }

    private void setIdProperty(T t, int id) {
        try {
            Field idField = type.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(t, id);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, "Failed to set ID property for the object.", e);
        }
    }
}
