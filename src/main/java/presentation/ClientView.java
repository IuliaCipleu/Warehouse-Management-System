package presentation;

import model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The ClientView class represents the GUI for managing client accounts.
 * It extends JFrame and contains several GUI components such as buttons, labels, and text fields.
 * It also has a JComboBox for selecting whether to edit or delete an existing client.
 * The class takes an ArrayList of Client objects as a parameter in its constructor.
 * The class has a ClientTableModel object for displaying the clients in a JTable.
 */
public class ClientView extends JFrame {
    private JTextField nameTextField;
    private JTextField addressTextField;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JComboBox comboBox;
    private JButton createButton;
    private JButton showAllClientsButton;
    private JButton resetButton;
    private ClientTableModel clientTableModel;

    /**
     * Constructs a ClientView object with the specified ArrayList of clients.
     *
     * @param clients the ArrayList of clients to be managed
     */
    public ClientView(ArrayList<Client> clients) {
        this.getContentPane().setBackground(new Color(124, 205, 244));
        this.setBounds(100, 100, 886, 704);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("MANAGE CLIENT ACCOUNT");
        titleLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 25));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(264, 11, 342, 33);
        this.getContentPane().add(titleLabel);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        nameLabel.setBounds(63, 114, 51, 20);
        this.getContentPane().add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setHorizontalAlignment(SwingConstants.LEFT);
        nameTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        nameTextField.setBounds(177, 116, 220, 20);
        this.getContentPane().add(nameTextField);
        nameTextField.setColumns(10);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addressLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        addressLabel.setBounds(460, 116, 64, 20);
        this.getContentPane().add(addressLabel);

        addressTextField = new JTextField();
        addressTextField.setHorizontalAlignment(SwingConstants.LEFT);
        addressTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        addressTextField.setColumns(10);
        addressTextField.setBounds(587, 115, 220, 20);
        this.getContentPane().add(addressTextField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        emailLabel.setBounds(63, 165, 42, 20);
        this.getContentPane().add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
        emailTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        emailTextField.setColumns(10);
        emailTextField.setBounds(177, 166, 220, 20);
        this.getContentPane().add(emailTextField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passwordLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        passwordLabel.setBounds(460, 165, 73, 20);
        this.getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(587, 167, 220, 20);
        this.getContentPane().add(passwordField);

        JLabel infoLabel = new JLabel("If the client already exists:");
        infoLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
        infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        infoLabel.setBounds(63, 226, 177, 20);
        this.getContentPane().add(infoLabel);

        comboBox = new JComboBox();
        comboBox.setBackground(new Color(197, 198, 198));
        comboBox.setToolTipText("");
        comboBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Edit", "Delete"}));
        comboBox.setBounds(264, 227, 133, 22);
        this.getContentPane().add(comboBox);

        JLabel info2Label = new JLabel("Else: ");
        info2Label.setHorizontalAlignment(SwingConstants.LEFT);
        info2Label.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
        info2Label.setBounds(460, 231, 73, 20);
        this.getContentPane().add(info2Label);

        createButton = new JButton("Create");
        createButton.setBackground(new Color(197, 198, 198));
        createButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        createButton.setBounds(587, 227, 89, 23);
        this.getContentPane().add(createButton);

        showAllClientsButton = new JButton("SHOW ALL CLIENTS");
        showAllClientsButton.setBackground(new Color(197, 198, 198));
        showAllClientsButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        showAllClientsButton.setBounds(342, 262, 186, 29);
        this.getContentPane().add(showAllClientsButton);

        String[] columnNamesClients = {"ID", "Name", "Address", "Email"};
        JTable table = new JTable();
        table.setBackground(new Color(44, 66, 104));
        table.setForeground(new Color(235, 235, 235, 255));
        table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        table.setRowHeight(25);

        clientTableModel = new ClientTableModel();
        table.setModel(clientTableModel);
        int columnNumber = table.getColumnCount();
        for (int i = 0; i < columnNumber; i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(columnNamesClients[i]);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(63, 340, 744, 270);
        getContentPane().add(scrollPane);

        if (!clients.isEmpty()) {
            clientTableModel.putClients(clients);
        }

        resetButton = new JButton("RESET");
        resetButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        resetButton.setBackground(new Color(197, 198, 198));
        resetButton.setBounds(342, 302, 186, 29);
        this.getContentPane().add(resetButton);

        this.setVisible(true);
    }

    public String getNameTextField() {
        return nameTextField.getText();
    }

    public void setNameTextField(String nameTextField) {
        this.nameTextField.setText(nameTextField);
    }

    public String getAddressTextField() {
        return addressTextField.getText();
    }

    public void setAddressTextField(String addressTextField) {
        this.addressTextField.setText(addressTextField);
    }

    public String getEmailTextField() {
        return emailTextField.getText();
    }

    public void setEmailTextField(String emailTextField) {
        this.emailTextField.setText(emailTextField);
    }

    public String getPasswordField() {
        return passwordField.getText();
    }

    public void setPasswordField(String passwordField) {
        this.passwordField.setText(passwordField);
    }

    public int getComboBox() {
        return comboBox.getSelectedIndex();
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public JButton getShowAllClientsButton() {
        return showAllClientsButton;
    }

    public void setShowAllClientsButton(JButton showAllClientsButton) {
        this.showAllClientsButton = showAllClientsButton;
    }

    public ClientTableModel getClientTableModel() {
        return clientTableModel;
    }

    public void setClientTableModel(ClientTableModel clientTableModel) {
        this.clientTableModel = clientTableModel;
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        refresh();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void refresh() {
        nameTextField.setText(null);
        addressTextField.setText(null);
        emailTextField.setText(null);
        passwordField.setText(null);
    }

    public void editDelete(ActionListener actionListener) {
        comboBox.addActionListener(actionListener);
    }

    public void create(ActionListener actionListener) {
        createButton.addActionListener(actionListener);
    }

    public void showAll(ActionListener actionListener) {
        showAllClientsButton.addActionListener(actionListener);
    }

    public void reset(ActionListener actionListener) {
        resetButton.addActionListener(actionListener);
    }
}