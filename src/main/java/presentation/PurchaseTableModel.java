package presentation;

import model.Purchase;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
/**
 * This class represents the table model used to display a list of purchases in a JTable.
 */
public class PurchaseTableModel extends AbstractTableModel {
    /**
     * The list of orders to display.
     */
    private List<Purchase> ordersList = new ArrayList<>();
    /**
     * Returns the number of rows in the table.
     *
     * @return The number of rows in the table.
     */
    @Override
    public int getRowCount() {
        return ordersList.size();
    }
    /**
     * Returns the number of columns in the table.
     *
     * @return The number of columns in the table.
     */
    @Override
    public int getColumnCount() {
        return 4;
    }
    /**
     * Returns the value at the specified cell in the table.
     *
     * @param rowIndex    The row index of the cell.
     * @param columnIndex The column index of the cell.
     * @return The value at the specified cell.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Purchase currentPurchase = ordersList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return currentPurchase.getId();
            case 1:
                return currentPurchase.getIdClient();
            case 2:
                return currentPurchase.getIdProduct();
            case 3:
                return currentPurchase.getQuantity();
        }
        return null;
    }
    /**
     * Sets the list of purchases to display in the table.
     *
     * @param ordersList The list of bills to display.
     */
    public void putOrders(List<Purchase> ordersList) {
        this.ordersList = ordersList;
    }
}