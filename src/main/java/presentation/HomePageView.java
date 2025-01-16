package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Constructs a HomePageView object.
 */
public class HomePageView extends JFrame {

    private JButton clientButton;
    private JButton productButton;
    private JButton orderButton;

    public HomePageView() {
        this.getContentPane().setBackground(new Color(188, 227, 250));
        this.setBounds(100, 100, 780, 603);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("ORDERS MANAGEMENT APPLICATION");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 25));
        titleLabel.setBounds(145, 11, 474, 33);
        this.getContentPane().add(titleLabel);

        JLabel infoLabel = new JLabel("Welcome to our warehouse application! \r\nPlease select a task.");
        infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        infoLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        infoLabel.setBounds(97, 112, 570, 27);
        this.getContentPane().add(infoLabel);

        clientButton = new JButton("Edit Client Account");
        clientButton.setBackground(new Color(235, 235, 235));
        clientButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        clientButton.setBounds(78, 224, 182, 29);
        this.getContentPane().add(clientButton);

        productButton = new JButton("Edit Product");
        productButton.setBackground(new Color(235, 235, 235));
        productButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        productButton.setBounds(338, 224, 135, 29);
        this.getContentPane().add(productButton);

        orderButton = new JButton("Place Order");
        orderButton.setBackground(new Color(235, 235, 235));
        orderButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        orderButton.setBounds(551, 224, 135, 29);
        this.getContentPane().add(orderButton);

        JLabel iconClientLabel = new JLabel("");
        iconClientLabel.setIcon(new ImageIcon("C:\\Users\\Cipleu\\Documents\\IULIA\\SCOALA\\facultate\\Year2Semester2\\PT\\Lab\\tema3\\PT2023_30423_Cipleu_Iulia_Assignment_3\\PT2023_30423_Cipleu_Iulia_Assignment_3\\icons\\Hopstarter-Sleek-Xp-Basic-Clients.128.png"));
        iconClientLabel.setBackground(new Color(188, 227, 250));
        iconClientLabel.setBounds(78, 264, 182, 171);
        this.getContentPane().add(iconClientLabel);

        JLabel iconProductLabel = new JLabel("");
        iconProductLabel.setIcon(new ImageIcon("C:\\Users\\Cipleu\\Documents\\IULIA\\SCOALA\\facultate\\Year2Semester2\\PT\\Lab\\tema3\\PT2023_30423_Cipleu_Iulia_Assignment_3\\PT2023_30423_Cipleu_Iulia_Assignment_3\\icons\\Icons8-Ios7-City-Warehouse.128.png"));
        iconProductLabel.setBackground(new Color(188, 227, 250));
        iconProductLabel.setBounds(338, 264, 135, 135);
        this.getContentPane().add(iconProductLabel);

        JLabel iconOrderLabel = new JLabel();
        iconOrderLabel.setIcon(new ImageIcon("C:\\Users\\Cipleu\\Documents\\IULIA\\SCOALA\\facultate\\Year2Semester2\\PT\\Lab\\tema3\\PT2023_30423_Cipleu_Iulia_Assignment_3\\PT2023_30423_Cipleu_Iulia_Assignment_3\\icons\\Fasticon-Shop-Cart-Shop-cart-add.128.png"));
        iconOrderLabel.setBackground(new Color(188, 227, 250));
        iconOrderLabel.setBounds(551, 264, 135, 135);
        this.getContentPane().add(iconOrderLabel);

        this.setVisible(true);
    }

    public JButton getClientButton() {
        return clientButton;
    }

    public void setClientButton(JButton clientButton) {
        this.clientButton = clientButton;
    }

    public JButton getProductButton() {
        return productButton;
    }

    public void setProductButton(JButton productButton) {
        this.productButton = productButton;
    }

    public JButton getOrderButton() {
        return orderButton;
    }

    public void setOrderButton(JButton orderButton) {
        this.orderButton = orderButton;
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void goToClient(ActionListener actionListener) {
        clientButton.addActionListener(actionListener);
    }

    public void goToProduct(ActionListener actionListener) {
        productButton.addActionListener(actionListener);
    }

    public void goToOrder(ActionListener actionListener) {
        orderButton.addActionListener(actionListener);
    }

}