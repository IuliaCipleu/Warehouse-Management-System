package bll;

import dao.PurchaseDAO;
import model.Purchase;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The PurchaseBLL class represents the business logic layer for the Purchase model.
 * It communicates with the PurchaseDAO data access object to perform CRUD (create, read, update, delete) operations on purchases.
 */
public class PurchaseBLL {
    private PurchaseDAO purchaseDAO;

    /**
     * Constructs a new PurchaseBLL object and initializes the PurchaseDAO data access object.
     *
     * @throws SQLException if there is a problem with the database connection.
     */
    public PurchaseBLL() throws SQLException {
        purchaseDAO = new PurchaseDAO();
    }

    /**
     * Finds a purchase with the specified ID.
     *
     * @param id the ID of the purchase to find.
     * @return the Purchase object if found.
     * @throws SQLException           if there is a problem with the database connection.
     * @throws NoSuchElementException if the purchase with the specified ID was not found.
     */
    public Purchase findOrderById(int id) throws SQLException {
        Purchase purchase = purchaseDAO.findById(id);
        if (purchase == null) {
            throw new NoSuchElementException("The Order with id =" + id + " was not found!");
        }
        return purchase;
    }

    /**
     * Finds all purchases made by a specific client.
     *
     * @param id the ID of the client.
     * @return a List of Purchase objects made by the client.
     * @throws SQLException if there is a problem with the database connection.
     */
    public List<Purchase> findOrderByClient(int id) throws SQLException {
        List<Purchase> purchase = (List<Purchase>) purchaseDAO.findByClient(id);
        if (purchase.isEmpty()) {
            //throw new NoSuchElementException("The Order with id =" + id + " was not found!");
            return null;
        }
        return purchase;
    }

    /**
     * Finds all purchases containing a specific product.
     *
     * @param id the ID of the product.
     * @return a List of Purchase objects containing the product.
     * @throws SQLException if there is a problem with the database connection.
     */
    public List<Purchase> findOrderByProduct(int id) throws SQLException {
        List<Purchase> purchase = (List<Purchase>) purchaseDAO.findByProduct(id);
        if (purchase.isEmpty()) {
            //throw new NoSuchElementException("The Order with id =" + id + " was not found!");
            return null;
        }
        return purchase;
    }

    /**
     * Inserts a new purchase into the database.
     *
     * @param purchase the Purchase object to insert.
     * @return the ID of the new purchase.
     * @throws SQLException if there is a problem with the database connection.
     */
    public int insertOrder(Purchase purchase) throws SQLException {
        return purchaseDAO.insert(purchase).getId();
    }

    /**
     * Deletes a purchase from the database.
     *
     * @param purchase the Purchase object to delete.
     * @throws SQLException if there is a problem with the database connection.
     */
    public void deleteOrder(Purchase purchase) throws SQLException {
        purchaseDAO.delete(purchase);
    }

    /**
     * Updates a purchase in the database.
     *
     * @param purchase the updated Purchase object.
     * @param oldId    the ID of the purchase to update.
     * @throws SQLException if there is a problem with the database connection.
     */
    public void editOrder(Purchase purchase, int oldId) throws SQLException {
        purchaseDAO.update(purchase, oldId);
    }

    /**
     * Finds all purchases in the database.
     *
     * @return a List of all Purchase objects in the database.
     * @throws NoSuchElementException if there are no purchases in the database.
     */
    public List<Purchase> getAllOrders() throws NoSuchElementException {
        List<Purchase> purchases = purchaseDAO.findAll();
        if (purchases == null) {
            throw new NoSuchElementException("Error: There are no orders in database!");
        }
        return purchases;
    }
}