package model;
/**
 * Represents a client in the system.
 */
public class Client {
    private int id;
    private String name;
    private String address;
    private String email;
    private String password;

    /**
     * Constructs a client with the specified ID, name, address, and email.
     *
     * @param id      the ID of the client
     * @param name    the name of the client
     * @param address the address of the client
     * @param email   the email address of the client
     */

    public Client(int id, String name, String address, String email) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    /**
     * Constructs a new client with default values for all fields.
     */

    public Client() {
    }

    /**
     * Constructs a client with the specified ID, name, address, email, and password.
     *
     * @param id       the ID of the client
     * @param name     the name of the client
     * @param address  the address of the client
     * @param email    the email address of the client
     * @param password the password of the client
     */

    public Client(int id, String name, String address, String email, String password) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructs a client with the specified name, address, email, and password.
     *
     * @param name     the name of the client
     * @param address  the address of the client
     * @param email    the email address of the client
     * @param password the password of the client
     */

    public Client(String name, String address, String email, String password) {
        super();
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }
    /**
     * Returns the ID of the client.
     *
     * @return the ID of the client
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the ID of the client.
     *
     * @param id the ID of the client
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Returns the name of the client.
     *
     * @return the name of the client
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the client.
     *
     * @param name the name of the client
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the address of the client.
     *
     * @return the address of the client
     */
    public String getAddress() {
        return address;
    }
    /**
     * Sets the address of the client.
     *
     * @param address the address of the client
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Returns the email of the client.
     *
     * @return the email of the client
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets the email of the client.
     *
     * @param email the email of the client
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Returns the password of the client.
     *
     * @return the password of the client
     */

    public String getPassword() {
        return password;
    }
    /**
     * Sets the password of the client.
     *
     * @param password the password of the client
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}