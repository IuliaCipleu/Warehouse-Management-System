package model;

/**
 * Represents a purchase in the system.
 */
public class Purchase {
    private int id;
    private int idClient;
    private int idProduct;
    private int quantity;

    /**
     * Constructs a purchase with the specified ID, ID Client, ID Product, quantity.
     *
     * @param id        the ID of the purchase
     * @param idClient  the ID of the Client of the purchase
     * @param idProduct the ID of the Product of the purchase
     * @param quantity  the quantity of the purchase
     */
    public Purchase(int id, int idClient, int idProduct, int quantity) {
        this.id = id;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    /**
     * Constructs a new product with default values for all fields.
     */
    public Purchase() {
    }

    /**
     * Constructs a purchase with the specified ID Client, ID Product, quantity.
     *
     * @param idClient  the ID of the Client of the purchase
     * @param idProduct the ID of the Product of the purchase
     * @param quantity  the quantity of the purchase
     */
    public Purchase(int idClient, int idProduct, int quantity) {
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}