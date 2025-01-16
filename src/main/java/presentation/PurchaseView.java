package presentation;

import model.Purchase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This Java code defines a class PurchaseView in the presentation package, which extends the JFrame class.
 * This class is used to create a graphical user interface for managing purchase orders.
 * The class contains several components such as text fields, buttons, and labels to collect and display information about purchase orders.
 */
public class PurchaseView extends JFrame {
    private JTextField clientTextField;
    private JTextField productTextField;
    private JTextField quantityTextField;
    private JButton placeOrderButton;
    private JButton resetButton;
    private JButton showAllOrdersButton;
    private JButton billButton;
    private JPasswordField passwordField;
    private JTextField newProductTextField;
    private JTextField newQuantityTextField;
    private JButton editOrderButton;
    private JButton deleteOrderButton;
    private JTextArea finalPriceTextArea;
    private JTextField idOrderTextField;

    /**
     * The PurchaseView constructor takes an ArrayList of Purchase objects as an argument, which is used to initialize the view with the existing purchase orders.
     *
     * @param purchases the ArrayList of purchases to be managed
     */
    public PurchaseView(ArrayList<Purchase> purchases) {
        this.getContentPane().setBackground(new Color(92, 243, 255));
        this.setBounds(100, 100, 892, 702);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblManageProduct = new JLabel("MANAGE ORDER");
        lblManageProduct.setHorizontalAlignment(SwingConstants.CENTER);
        lblManageProduct.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 25));
        lblManageProduct.setBounds(267, 11, 342, 33);
        this.getContentPane().add(lblManageProduct);

        JLabel clientLabel = new JLabel("Email Client:");
        clientLabel.setHorizontalAlignment(SwingConstants.LEFT);
        clientLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        clientLabel.setBounds(78, 63, 88, 20);
        this.getContentPane().add(clientLabel);

        clientTextField = new JTextField();
        clientTextField.setHorizontalAlignment(SwingConstants.LEFT);
        clientTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        clientTextField.setColumns(10);
        clientTextField.setBounds(232, 63, 154, 20);
        this.getContentPane().add(clientTextField);

        JLabel productLabel = new JLabel("Product Name:");
        productLabel.setHorizontalAlignment(SwingConstants.LEFT);
        productLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        productLabel.setBounds(78, 94, 109, 20);
        this.getContentPane().add(productLabel);

        productTextField = new JTextField();
        productTextField.setHorizontalAlignment(SwingConstants.LEFT);
        productTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        productTextField.setColumns(10);
        productTextField.setBounds(232, 95, 154, 20);
        this.getContentPane().add(productTextField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setHorizontalAlignment(SwingConstants.LEFT);
        quantityLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        quantityLabel.setBounds(420, 95, 66, 20);
        this.getContentPane().add(quantityLabel);

        quantityTextField = new JTextField();
        quantityTextField.setHorizontalAlignment(SwingConstants.LEFT);
        quantityTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        quantityTextField.setColumns(10);
        quantityTextField.setBounds(576, 95, 154, 20);
        this.getContentPane().add(quantityTextField);

        placeOrderButton = new JButton("PLACE ORDER");
        placeOrderButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        placeOrderButton.setBackground(new Color(235, 235, 235));
        placeOrderButton.setBounds(140, 245, 246, 29);
        this.getContentPane().add(placeOrderButton);

        resetButton = new JButton("RESET");
        resetButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        resetButton.setBackground(new Color(235, 235, 235));
        resetButton.setBounds(420, 325, 246, 29);
        this.getContentPane().add(resetButton);

        JLabel finalPriceLabel = new JLabel("Final Price: ");
        finalPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
        finalPriceLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        finalPriceLabel.setBounds(397, 392, 81, 20);
        this.getContentPane().add(finalPriceLabel);

        finalPriceTextArea = new JTextArea();
        finalPriceTextArea.setEditable(false);
        finalPriceTextArea.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        finalPriceTextArea.setBounds(314, 410, 246, 20);
        this.getContentPane().add(finalPriceTextArea);

        showAllOrdersButton = new JButton("SHOW ALL ORDERS");
        showAllOrdersButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        showAllOrdersButton.setBackground(new Color(235, 235, 235));
        showAllOrdersButton.setBounds(420, 245, 246, 29);
        this.getContentPane().add(showAllOrdersButton);

        billButton = new JButton("BILL");
        billButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        billButton.setBackground(new Color(235, 235, 235));
        billButton.setBounds(140, 325, 246, 29);
        this.getContentPane().add(billButton);

        JLabel passwordLabel = new JLabel("Password Client:");
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passwordLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        passwordLabel.setBounds(420, 63, 119, 20);
        this.getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        passwordField.setBounds(576, 63, 154, 20);
        this.getContentPane().add(passwordField);

        JLabel newProductLabel = new JLabel("Edit Product:");
        newProductLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        newProductLabel.setBounds(78, 187, 94, 20);
        this.getContentPane().add(newProductLabel);

        newProductTextField = new JTextField();
        newProductTextField.setHorizontalAlignment(SwingConstants.LEFT);
        newProductTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        newProductTextField.setColumns(10);
        newProductTextField.setBounds(232, 187, 154, 20);
        this.getContentPane().add(newProductTextField);

        JLabel newQuantityLabel = new JLabel("Edit Quantity:");
        newQuantityLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        newQuantityLabel.setBounds(420, 187, 98, 20);
        this.getContentPane().add(newQuantityLabel);

        newQuantityTextField = new JTextField();
        newQuantityTextField.setHorizontalAlignment(SwingConstants.LEFT);
        newQuantityTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        newQuantityTextField.setColumns(10);
        newQuantityTextField.setBounds(576, 188, 154, 20);
        this.getContentPane().add(newQuantityTextField);

        editOrderButton = new JButton("EDIT ORDER");
        editOrderButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        editOrderButton.setBackground(new Color(235, 235, 235));
        editOrderButton.setBounds(140, 285, 246, 29);
        this.getContentPane().add(editOrderButton);

        deleteOrderButton = new JButton("DELETE ORDER");
        deleteOrderButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        deleteOrderButton.setBackground(new Color(235, 235, 235));
        deleteOrderButton.setBounds(420, 285, 246, 29);
        this.getContentPane().add(deleteOrderButton);

        JLabel infoLabel = new JLabel("If you want to update or delete the order with ID:");
        infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        infoLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        infoLabel.setBounds(78, 162, 357, 20);
        this.getContentPane().add(infoLabel);

        idOrderTextField = new JTextField();
        idOrderTextField.setHorizontalAlignment(SwingConstants.LEFT);
        idOrderTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        idOrderTextField.setColumns(10);
        idOrderTextField.setBounds(445, 163, 285, 20);
        this.getContentPane().add(idOrderTextField);

        String[] columnNamesProducts = {"ID", "ID Client", "ID Product", "Quantity"};
        JTable table = new JTable();
        table.setBackground(new Color(44, 66, 104));
        table.setForeground(new Color(235, 235, 235, 255));
        table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        table.setRowHeight(25);

        PurchaseTableModel purchaseTableModel = new PurchaseTableModel();
        table.setModel(purchaseTableModel);
        int columnNumber = table.getColumnCount();
        for (int i = 0; i < columnNumber; i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(columnNamesProducts[i]);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(28, 435, 820, 190);
        getContentPane().add(scrollPane);

        if (!purchases.isEmpty()) {
            purchaseTableModel.putOrders(purchases);
        }

        this.setVisible(true);
    }

    public String getClientTextField() {
        return clientTextField.getText();
    }

    public void setClientTextField(JTextField clientTextField) {
        this.clientTextField = clientTextField;
    }

    public String getProductTextField() {
        return productTextField.getText();
    }

    public void setProductTextField(JTextField productTextField) {
        this.productTextField = productTextField;
    }

    public Integer getQuantityTextField() {
        return Integer.parseInt(quantityTextField.getText());
    }

    public void setQuantityTextField(JTextField quantityTextField) {
        this.quantityTextField = quantityTextField;
    }

    public JButton getPlaceOrderButton() {
        return placeOrderButton;
    }

    public void setPlaceOrderButton(JButton placeOrderButton) {
        this.placeOrderButton = placeOrderButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }

    public JTextArea getFinalPriceTextArea() {
        return finalPriceTextArea;
    }

    public void setFinalPriceTextArea(Double finalPriceTextArea) {
        this.finalPriceTextArea.setText(String.valueOf(finalPriceTextArea));
    }

    public JButton getShowAllOrdersButton() {
        return showAllOrdersButton;
    }

    public void setShowAllOrdersButton(JButton showAllOrdersButton) {
        this.showAllOrdersButton = showAllOrdersButton;
    }

    public JButton getBillButton() {
        return billButton;
    }

    public void setBillButton(JButton billButton) {
        this.billButton = billButton;
    }

    public String getPasswordField() {
        return passwordField.getText();
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public String getNewProductTextField() {
        return newProductTextField.getText();
    }

    public void setNewProductTextField(JTextField newProductTextField) {
        this.newProductTextField = newProductTextField;
    }

    public Integer getNewQuantityTextField() {
        return Integer.parseInt(newQuantityTextField.getText());
    }

    public void setNewQuantityTextField(JTextField newQuantityTextField) {
        this.newQuantityTextField = newQuantityTextField;
    }

    public JButton getEditOrderButton() {
        return editOrderButton;
    }

    public void setEditOrderButton(JButton editOrderButton) {
        this.editOrderButton = editOrderButton;
    }

    public JButton getDeleteOrderButton() {
        return deleteOrderButton;
    }

    public void setDeleteOrderButton(JButton deleteOrderButton) {
        this.deleteOrderButton = deleteOrderButton;
    }

    public Integer getIdOrderTextField() {
        return Integer.parseInt(idOrderTextField.getText());
    }

    public void setIdOrderTextField(JTextField idOrderTextField) {
        this.idOrderTextField = idOrderTextField;
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        refresh();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void refresh() {
        clientTextField.setText(null);
        quantityTextField.setText(null);
        productTextField.setText(null);
        finalPriceTextArea.setText(null);
        passwordField.setText(null);
        newProductTextField.setText(null);
        newQuantityTextField.setText(null);
        idOrderTextField.setText(null);
    }

    public void placeOrder(ActionListener actionListener) {
        placeOrderButton.addActionListener(actionListener);
    }

    public void showAll(ActionListener actionListener) {
        showAllOrdersButton.addActionListener(actionListener);
    }

    public void goToBill(ActionListener actionListener) {
        billButton.addActionListener(actionListener);
    }

    public void edit(ActionListener actionListener) {
        editOrderButton.addActionListener(actionListener);
    }

    public void delete(ActionListener actionListener) {
        deleteOrderButton.addActionListener(actionListener);
    }

    public void reset(ActionListener actionListener) {
        resetButton.addActionListener(actionListener);
    }
}