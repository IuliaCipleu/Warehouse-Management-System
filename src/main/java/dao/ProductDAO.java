package dao;

import connection.ConnectionFactory;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ProductDAO class provides methods for interacting with the database table "product".
 * It extends the AbstractDAO class and inherits its methods and properties.
 */
public class ProductDAO extends AbstractDAO<Product> {
    /**
     * This Logger object provides logging functionality for the class.
     */
    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    /**
     * This string contains the SQL statement for finding a product by name.
     */
    private final static String findByNameStatementString = "SELECT * FROM product where  name = ?";

    /**
     * This method finds a product in the database by its name.
     *
     * @param name The name of the product to be found.
     * @return The Product object found by the name, or null if no such product exists in the database.
     */
    public static Product findByName(String name) {
        Product toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findByNameStatementString);
            findStatement.setString(1, name);
            rs = findStatement.executeQuery();
            rs.next();
            int productId = rs.getInt("id");
            Double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            toReturn = new Product(productId, name, price, quantity);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }
}