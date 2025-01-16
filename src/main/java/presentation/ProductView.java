package presentation;

import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The ProductView class represents the GUI for managing products.
 * It extends JFrame and contains several GUI components such as buttons, labels, and text fields.
 * It also has a JComboBox for selecting whether to edit or delete an existing product.
 * The class takes an ArrayList of Product objects as a parameter in its constructor.
 * The class has a ProductTableModel object for displaying the products in a JTable.
 */
public class ProductView extends JFrame {
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField quantityTextField;
    private JComboBox comboBox;
    private JButton addButton;
    private JButton showAllProductsButton;
    private JButton resetButton;

    /**
     * Constructs a ProductView object with the specified ArrayList of products.
     *
     * @param products the ArrayList of products to be managed
     */
    public ProductView(ArrayList<Product> products) {
        this.getContentPane().setBackground(new Color(0, 200, 240));
        this.getContentPane().setForeground(new Color(0, 169, 226));
        this.setBounds(100, 100, 924, 684);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblManageProduct = new JLabel("MANAGE PRODUCT");
        lblManageProduct.setHorizontalAlignment(SwingConstants.CENTER);
        lblManageProduct.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 25));
        lblManageProduct.setBounds(283, 11, 342, 33);
        this.getContentPane().add(lblManageProduct);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        nameLabel.setBounds(37, 83, 51, 20);
        this.getContentPane().add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setHorizontalAlignment(SwingConstants.LEFT);
        nameTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        nameTextField.setColumns(10);
        nameTextField.setBounds(125, 83, 154, 20);
        this.getContentPane().add(nameTextField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setHorizontalAlignment(SwingConstants.LEFT);
        priceLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        priceLabel.setBounds(316, 83, 64, 20);
        this.getContentPane().add(priceLabel);

        priceTextField = new JTextField();
        priceTextField.setHorizontalAlignment(SwingConstants.LEFT);
        priceTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        priceTextField.setColumns(10);
        priceTextField.setBounds(417, 83, 154, 20);
        this.getContentPane().add(priceTextField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setHorizontalAlignment(SwingConstants.LEFT);
        quantityLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        quantityLabel.setBounds(608, 83, 66, 20);
        this.getContentPane().add(quantityLabel);

        quantityTextField = new JTextField();
        quantityTextField.setHorizontalAlignment(SwingConstants.LEFT);
        quantityTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        quantityTextField.setColumns(10);
        quantityTextField.setBounds(711, 83, 154, 20);
        this.getContentPane().add(quantityTextField);

        JLabel infoLabel = new JLabel("If the product already exists:");
        infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        infoLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
        infoLabel.setBounds(37, 141, 207, 20);
        this.getContentPane().add(infoLabel);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Edit", "Delete"}));
        comboBox.setToolTipText("");
        comboBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        comboBox.setBackground(new Color(235, 235, 235));
        comboBox.setBounds(316, 140, 133, 22);
        this.getContentPane().add(comboBox);

        JLabel info2Label = new JLabel("Else: ");
        info2Label.setHorizontalAlignment(SwingConstants.LEFT);
        info2Label.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
        info2Label.setBounds(537, 141, 34, 20);
        this.getContentPane().add(info2Label);

        addButton = new JButton("Add");
        addButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        addButton.setBackground(new Color(235, 235, 235));
        addButton.setBounds(608, 140, 89, 23);
        this.getContentPane().add(addButton);

        showAllProductsButton = new JButton("SHOW ALL PRODUCTS");
        showAllProductsButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        showAllProductsButton.setBackground(new Color(235, 235, 235));
        showAllProductsButton.setBounds(336, 203, 236, 29);
        this.getContentPane().add(showAllProductsButton);

        String[] columnNamesProducts = {"ID", "Name", "Price", "Quantity"};
        JTable table = new JTable();
        table.setBackground(new Color(44, 66, 104));
        table.setForeground(new Color(235, 235, 235, 255));
        table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        table.setRowHeight(25);

        ProductTableModel productTableModel = new ProductTableModel();
        table.setModel(productTableModel);
        int columnNumber = table.getColumnCount();
        for (int i = 0; i < columnNumber; i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(columnNamesProducts[i]);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(37, 295, 828, 320);
        getContentPane().add(scrollPane);

        if (!products.isEmpty()) {
            productTableModel.setProducts(products);
        }

        resetButton = new JButton("RESET");
        resetButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        resetButton.setBackground(new Color(235, 235, 235));
        resetButton.setBounds(336, 256, 236, 29);
        this.getContentPane().add(resetButton);

        this.setVisible(true);
    }

    public String getNameTextField() {
        return nameTextField.getText();
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public Double getPriceTextField() {
        return Double.parseDouble(priceTextField.getText());
    }

    public void setPriceTextField(JTextField priceTextField) {
        this.priceTextField = priceTextField;
    }

    public Integer getQuantityTextField() {
        return Integer.parseInt(quantityTextField.getText());
    }

    public void setQuantityTextField(JTextField quantityTextField) {
        this.quantityTextField = quantityTextField;
    }

    public int getComboBox() {
        return comboBox.getSelectedIndex();
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getShowAllProductsButton() {
        return showAllProductsButton;
    }

    public void setShowAllProductsButton(JButton showAllProductsButton) {
        this.showAllProductsButton = showAllProductsButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
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
        priceTextField.setText(null);
        quantityTextField.setText(null);
    }

    public void editDelete(ActionListener actionListener) {
        comboBox.addActionListener(actionListener);
    }

    public void create(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void showAll(ActionListener actionListener) {
        showAllProductsButton.addActionListener(actionListener);
    }

    public void reset(ActionListener actionListener) {
        resetButton.addActionListener(actionListener);
    }
}