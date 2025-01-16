package bll;

import dao.ProductDAO;
import model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The {@code ProductBLL} class represents a business logic layer for the Product model.
 * It provides methods to access and manipulate product data from the database.
 */
public class ProductBLL {
    private ProductDAO productDAO;

    /**
     * Constructs a new ProductBLL object and initializes the ProductDAO.
     *
     * @throws SQLException if a database access error occurs
     */
    public ProductBLL() throws SQLException {
        productDAO = new ProductDAO();
    }

    /**
     * Finds a product by its name.
     *
     * @param name the name of the product to find
     * @return the Product object with the given name
     * @throws SQLException           if a database access error occurs
     * @throws NoSuchElementException if no product with the given name is found
     */
    public Product findProductByName(String name) throws SQLException {
        Product product = productDAO.findByName(name);
        if (product == null) {
            throw new NoSuchElementException("The Product with name =" + name + " was not found!");
        }
        return product;
    }

    /**
     * Finds a product by its id.
     *
     * @param id the id of the product to find
     * @return the Product object with the given id
     * @throws SQLException           if a database access error occurs
     * @throws NoSuchElementException if no product with the given id is found
     */
    public Product findProductById(int id) throws SQLException {
        Product product = productDAO.findById(id);
        if (product == null) {
            throw new NoSuchElementException("The Product with id =" + id + " was not found!");
        }
        return product;
    }

    /**
     * Inserts a new product into the database.
     *
     * @param product the product object to insert
     * @return the id of the inserted product
     * @throws SQLException if a database access error occurs
     */

    public int insertProduct(Product product) throws SQLException {
        if (product.getQuantity() > 0 && product.getPrice() > 0) {
            return productDAO.insert(product).getId();
        } else return -2;
    }

    /**
     * Deletes a product from the database.
     *
     * @param product the product object to delete
     * @throws SQLException if a database access error occurs
     */
    public void deleteProduct(Product product) throws SQLException {
        productDAO.delete(product);
    }

    /**
     * Updates a product in the database.
     *
     * @param product the product object to update
     * @param oldId   the id of the old product to be replaced
     * @throws SQLException if a database access error occurs
     */
    public void editProduct(Product product, int oldId) throws SQLException {
        productDAO.update(product, oldId);
    }

    /**
     * Retrieves all products from the database.
     *
     * @return a list of all products
     * @throws NoSuchElementException if there are no products in the database
     */
    public List<Product> getAllProducts() throws NoSuchElementException {
        List<Product> products = productDAO.findAll();
        if (products == null) {
            throw new NoSuchElementException("Error: There are no products in database!");
        }
        return products;
    }
}