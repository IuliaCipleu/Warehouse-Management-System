package presentation;

import model.Bill;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This Java class is named BillView, and it's located in the presentation package.
 * It imports two classes from the model package (Bill and BillTableModel) and two classes from the javax.swing and java.awt packages (JFrame and Color, respectively).
 * The BillView class extends the JFrame class, which is a top-level container that represents a window.
 */
public class BillView extends JFrame {
    private BillTableModel billTableModel;

    /**
     * The constructor of the BillView class receives an ArrayList of Bill objects as a parameter.
     *
     * @param bills the ArrayList of bills to be managed
     */
    public BillView(ArrayList<Bill> bills) {
        this.getContentPane().setBackground(new Color(204, 255, 255));
        this.setBackground(new Color(153, 255, 255));
        this.setBounds(100, 100, 786, 638);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("BILL");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 25));
        titleLabel.setBounds(360, 11, 50, 33);
        this.getContentPane().add(titleLabel);

        String[] columnNamesBills = {"ID", "Name Client", "Email", "Product", "Quantity", "Price Product", "Total Price"};
        JTable table = new JTable();
        table.setBackground(new Color(44, 66, 104));
        table.setForeground(new Color(235, 235, 235, 255));
        table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        table.setRowHeight(25);

        billTableModel = new BillTableModel();
        table.setModel(billTableModel);
        int columnNumber = table.getColumnCount();
        for (int i = 0; i < columnNumber; i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(columnNamesBills[i]);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(43, 70, 684, 450);
        getContentPane().add(scrollPane);

        if (!bills.isEmpty()) {
            billTableModel.putBills(bills);
        }


        this.setVisible(true);
    }
}