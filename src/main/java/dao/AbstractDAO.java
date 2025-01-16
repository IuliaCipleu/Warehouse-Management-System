package dao;

import connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a generic Data Access Object (DAO) which provides basic CRUD operations
 * for accessing and manipulating data stored in a database table.
 *
 * @param <T> The entity type of the DAO.
 */
public class AbstractDAO<T> {
    /**
     * The logger instance used for logging messages.
     */
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    /**
     * The type of the entity associated with this DAO.
     */
    private final Class<T> type;

    /**
     * Constructs a new AbstractDAO instance.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Creates a select query string for selecting a row with the given field.
     *
     * @param field The field.
     * @return The select query string.
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Creates a select query string for selecting all rows in the table.
     *
     * @return The select query string.
     */
    private String createAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * Creates an update query string for updating a row in the table.
     *
     * @return The update query string.
     */
    private String createUpdateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for (Field field : type.getDeclaredFields()) {
            if (!field.getName().equals(type.getDeclaredFields()[0].getName())) {
                sb.append(field.getName() + " = ?,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" WHERE " + type.getDeclaredFields()[0].getName() + " = ?");
        return sb.toString();
    }

    /**
     * Creates a delete query string for deleting a row from the table.
     *
     * @return The delete query string.
     */
    private String createDeleteQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + type.getDeclaredFields()[0].getName() + " = ?");
        return sb.toString();
    }

    /**
     * Finds all rows in the table.
     *
     * @return A list of all rows.
     */
    public List<T> findAll() {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createAllQuery();
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
        return null;
    }

    /**
     * Finds an object by ID in the table.
     *
     * @param id searched ID
     * @return An object with the given ID.
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(type.getDeclaredFields()[0].getName());
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Returns the result of the query
     *
     * @param resultSet result of the query
     * @return A list off all results.
     */
    protected List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T instance = type.getDeclaredConstructor().newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Class<?> fieldType = field.getType();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    if (fieldType == double.class || fieldType == Double.class) {
                        method.invoke(instance, resultSet.getDouble(fieldName));
                    } else if (fieldType == int.class || fieldType == Integer.class) {
                        method.invoke(instance, resultSet.getInt(fieldName));
                    } else {
                        method.invoke(instance, value);
                    }
                }
                list.add(instance);
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | SQLException | IntrospectionException | NoSuchMethodException | SecurityException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:createObjects " + e.getMessage());
        }
        return list;
    }

    /**
     * Inserts an object into the table.
     *
     * @param t object of type T
     */
    public T insert(T t) {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = buildInsertQuery();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            Field[] fields = type.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                Object value = field.get(t);
                statement.setObject(i + 1, value);
            }

            statement.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    /**
     * Creates an insert query string for inserting a row into the table.
     *
     * @return The insert query string.
     */
    private String buildInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append(" (");

        Field[] fields = type.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i].getName());
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

    /**
     * Updates an object into the table.
     *
     * @param t  new object of type T
     * @param id ID of the object
     */
    public T update(T t, int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int index = 1;
            for (Field field : type.getDeclaredFields()) {
                if (!field.getName().equals("id")) {
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getReadMethod();
                    Object value = method.invoke(t);
                    statement.setObject(index, value);
                    index++;
                }
            }
            statement.setInt(index, id);
            statement.executeUpdate();
            return findById(id);
        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | IntrospectionException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Deletes an object into the table.
     *
     * @param t object of type T
     */
    public void delete(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(type.getDeclaredFields()[0].getName(), type);
            Method method = propertyDescriptor.getReadMethod();
            Object value = method.invoke(t);
            statement.setObject(1, value);
            statement.executeUpdate();
        } catch (SQLException | IllegalAccessException | IntrospectionException | InvocationTargetException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}