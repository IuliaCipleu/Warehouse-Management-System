package model;

/**
 * Represents a bill in the system.
 */
public record Bill(int id, String nameClient, String email, String nameProduct, int quantity, double priceProduct,
                   double finalPrice) {
    /**
     * Constructs a new bill with default values for all fields.
     */
    public Bill() {
        this(0, "", "", "", 0, 0.0, 0.0);
    }

    /**
     * Constructs a bill with the specified ID, name client, email client, name product, quantity, price product, final price.
     *
     * @param id           the ID of the bill
     * @param nameClient   the name of the Client of the bill
     * @param email        the email of the Client of the bill
     * @param nameProduct  the name of the Product of the bill
     * @param quantity     the quantity of the bill
     * @param priceProduct the price of the Product of the bill
     * @param finalPrice   the final price of the bill
     */
    public Bill(int id, String nameClient, String email, String nameProduct, int quantity, double priceProduct, double finalPrice) {
        this.id = id;
        this.nameClient = nameClient;
        this.email = email;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.priceProduct = priceProduct;
        this.finalPrice = finalPrice;
    }
}