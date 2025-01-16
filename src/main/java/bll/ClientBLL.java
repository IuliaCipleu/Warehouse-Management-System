package bll;

import bll.validators.EmailValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The ClientBLL class provides methods to interact with the ClientDAO class and perform CRUD (Create, Read, Update, Delete)
 * operations on client data.
 */

public class ClientBLL {
    private ClientDAO clientDAO;
    private List<Validator<Client>> validators;
    /**
     * Constructs a new ClientBLL object.
     *
     * @throws SQLException if an SQL exception occurs
     */
    public ClientBLL() throws SQLException {
        clientDAO = new ClientDAO();
        validators = new ArrayList<>();
        validators.add(new EmailValidator());
    }

    /**
     * Retrieves a client by their ID.
     *
     * @param id the ID of the client to retrieve
     * @return the retrieved client
     * @throws SQLException           if an SQL exception occurs
     * @throws NoSuchElementException if no client with the given ID is found
     */
    public Client findClientById(int id) throws SQLException {
        Client client = clientDAO.findById(id);
        if (client == null) {
            throw new NoSuchElementException("The Client with id =" + id + " was not found!");
        }
        return client;
    }

    /**
     * Retrieves a client by their email address.
     *
     * @param email the email address of the client to retrieve
     * @return the retrieved client
     * @throws SQLException           if an SQL exception occurs
     * @throws NoSuchElementException if no client with the given email address is found
     */
    public Client findClientByEmail(String email) throws SQLException, NoSuchElementException, IllegalArgumentException {
        Client client = clientDAO.findByEmail(email);
//        for (Validator<Client> validator: validators){
//            validator.validate(client);
//        }
        if (client == null || email == null) {
            throw new NoSuchElementException("The Client with Email =" + email + " was not found!");
        }
        return client;
    }

    /**
     * Inserts a new client into the database.
     *
     * @param client the client to insert
     * @return the ID of the inserted client
     * @throws SQLException if an SQL exception occurs
     */
    public int insertClient(Client client) throws SQLException, NoSuchElementException, IllegalArgumentException {
        for (Validator<Client> validator: validators){
            validator.validate(client);
        }
        return clientDAO.insert(client).getId();
    }

    /**
     * Deletes a client from the database.
     *
     * @param client the client to delete
     * @throws SQLException if an SQL exception occurs
     */
    public void deleteClient(Client client) throws SQLException {
        clientDAO.delete(client);
    }

    /**
     * Updates a client in the database.
     *
     * @param client the updated client
     * @param oldId  the ID of the client to update
     * @throws SQLException if an SQL exception occurs
     */
    public void editClient(Client client, int oldId) throws SQLException {
        clientDAO.update(client, oldId);
    }

    /**
     * Retrieves a list of all clients in the database.
     *
     * @return a list of all clients in the database
     * @throws NoSuchElementException if there are no clients in the database
     */
    public List<Client> getAllClients() throws NoSuchElementException {
        List<Client> clients = clientDAO.findAll();
        if (clients == null) {
            throw new NoSuchElementException("Error: There are no clients in database!");
        }
        return clients;
    }
}