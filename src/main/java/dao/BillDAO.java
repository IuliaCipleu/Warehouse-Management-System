package dao;

import connection.ConnectionFactory;
import model.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The BillDAO class handles the communication with the database for the Bill model.
 */
public class BillDAO {
    /**
     * The logger for this class
     */
    protected static final Logger LOGGER = Logger.getLogger(BillDAO.class.getName());
    /**
     * The SQL statement used to insert a new Bill into the database
     */
    private static final String insertStatementString = "INSERT INTO bill (`nameClient`, `email`, `nameProduct`, `quantity`, `priceProduct`, `finalPrice`) "
            + " VALUES (?,?,?,?,?,?)";
    /**
     * The SQL statement used to retrieve all the Bills from the database
     */
    private final static String getAllStatementString = "SELECT * FROM bill";

    /**
     * Inserts a new Bill into the database.
     *
     * @param bill the Bill object to insert into the database
     * @return the ID of the newly inserted Bill, or -1 if the insertion failed
     */
    public static int insert(Bill bill) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, bill.nameClient());
            insertStatement.setString(2, bill.email());
            insertStatement.setString(3, bill.nameProduct());
            insertStatement.setInt(4, bill.quantity());
            insertStatement.setDouble(5, bill.priceProduct());
            insertStatement.setDouble(6, bill.finalPrice());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "BillDAO: insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    /**
     * Retrieves all the Bills from the database.
     *
     * @return an ArrayList of all the Bills in the database
     */
    public static ArrayList<Bill> findAll() {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement getAllStatement = null;
        ArrayList<Bill> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            getAllStatement = dbConnection.prepareStatement(getAllStatementString);
            rs = getAllStatement.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt("id"), rs.getString("nameClient"), rs.getString("email"), rs.getString("nameProduct"), rs.getInt("quantity"), rs.getDouble("priceProduct"), rs.getDouble("finalPrice")));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "BillDAO: getAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(getAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return list;
    }
}