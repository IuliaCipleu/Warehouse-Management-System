package model;

/**
 * Represents a product in the system.
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructs a product with the specified ID, name, price, quantity.
     *
     * @param id       the ID of the product
     * @param name     the name of the product
     * @param price    the price of the product
     * @param quantity the quantity of the product
     */
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Constructs a new product with default values for all fields.
     */
    public Product() {
    }

    /**
     * Constructs a product with the specified name, price, quantity.
     *
     * @param name     the name of the product
     * @param price    the price of the product
     * @param quantity the quantity of the product
     */
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}