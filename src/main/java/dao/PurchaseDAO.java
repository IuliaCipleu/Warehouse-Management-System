package dao;

import connection.ConnectionFactory;
import model.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The PurchaseDAO class provides methods to access and modify the data of Purchase objects in the database.
 */
public class PurchaseDAO extends AbstractDAO<Purchase> {
    /**
     * The logger used to log any warnings or errors.
     */
    protected static final Logger LOGGER = Logger.getLogger(PurchaseDAO.class.getName());
    /**
     * The SQL statement used to find purchases by client ID.
     */
    private final static String findByClientStatementString = "SELECT * FROM purchase where  idClient = ?";
    /**
     * The SQL statement used to find purchases by product ID.
     */
    private final static String findByProductStatementString = "SELECT * FROM purchase where  idProduct = ?";

    /**
     * Finds all purchases made by a given client.
     *
     * @param idClient the ID of the client whose purchases are being searched for
     * @return a list of Purchase objects representing the purchases made by the client
     */
    public static List<Purchase> findByClient(int idClient) {
        Purchase toReturn = null;
        List<Purchase> list = new ArrayList<>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findByClientStatementString);
            findStatement.setInt(1, idClient);
            rs = findStatement.executeQuery();
            if (rs.next()) {
                int purchaseId = rs.getInt("id");
                int clientId = rs.getInt("idClient");
                int productId = rs.getInt("idProduct");
                int quantity = rs.getInt("quantity");
                toReturn = new Purchase(purchaseId, clientId, productId, quantity);
                list.add(toReturn);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "PurchaseDAO: findByClient " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return list;
    }

    /**
     * Finds all purchases of a given product.
     *
     * @param idProduct the ID of the product whose purchases are being searched for
     * @return a list of Purchase objects representing the purchases made of the product
     */
    public static List<Purchase> findByProduct(int idProduct) {
        Purchase toReturn = null;
        List<Purchase> list = new ArrayList<>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findByProductStatementString);
            findStatement.setInt(1, idProduct);
            rs = findStatement.executeQuery();
            if (rs.next()) {
                int purchaseId = rs.getInt("id");
                int clientId = rs.getInt("idClient");
                int productId = rs.getInt("idProduct");
                int quantity = rs.getInt("quantity");
                toReturn = new Purchase(purchaseId, clientId, productId, quantity);
                list.add(toReturn);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "PurchaseDAO: findByProduct " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return list;
    }
}