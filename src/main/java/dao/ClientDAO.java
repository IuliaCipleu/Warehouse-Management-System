package dao;

import connection.ConnectionFactory;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * The ClientDAO class represents the Data Access Object for the Client entity.
 * It extends the AbstractDAO class and provides methods for accessing and manipulating data in the database.
 */
public class ClientDAO extends AbstractDAO<Client> {
    /**
     * SQL statement to find a client by email
     */
    private final static String findByEmailStatementString = "SELECT * FROM client where  email = ?";

    /**
     * Finds a client with the given email.
     *
     * @param email the email of the client to be found
     * @return a Client object representing the found client or null if no client was found with the given email
     */
    public static Client findByEmail(String email) {
        Client toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findByEmailStatementString);
            findStatement.setString(1, email);
            rs = findStatement.executeQuery();
            if (rs.next()) {
                int clientId = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String password = rs.getString("password");
                toReturn = new Client(clientId, name, address, email, password);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO: findByEmail " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }
}