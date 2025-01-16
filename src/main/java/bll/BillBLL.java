/**
 * This package contains classes related to managing billing information for clients.
 * It includes classes for creating and updating bills, as well as retrieving bill data.
 */
package bll;

import dao.BillDAO;
import model.Bill;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The BillBLL class provides business logic methods for interacting with Bill objects in the database.
 */

public class BillBLL {
    private BillDAO billDAO;

    /**
     * Constructs a new BillBLL object and initializes its BillDAO instance variable.
     *
     * @throws SQLException if a database access error occurs while initializing the BillDAO object.
     */
    public BillBLL() throws SQLException {
        billDAO = new BillDAO();
    }

    /**
     * Returns a List of all Bill objects in the database.
     *
     * @return a List of all Bill objects in the database.
     * @throws NoSuchElementException if there are no Bill objects in the database.
     */
    public List<Bill> getAllBills() throws NoSuchElementException {
        List<Bill> bills = billDAO.findAll();
        if (bills == null) {
            throw new NoSuchElementException("Error: There are no bills in database!");
        }
        return bills;
    }

    /**
     * Inserts a new Bill object into the database.
     *
     * @param bill the Bill object to insert.
     * @return the ID of the newly inserted Bill object.
     */
    public int insertBill(Bill bill) {
        return BillDAO.insert(bill);
    }
}