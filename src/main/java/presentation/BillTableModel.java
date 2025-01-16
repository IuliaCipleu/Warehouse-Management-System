package presentation;

import model.Bill;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the table model used to display a list of bills in a JTable.
 */
public class BillTableModel extends AbstractTableModel {
    /**
     * The list of bills to display.
     */
    private List<Bill> billsList = new ArrayList<>();

    /**
     * Returns the number of rows in the table.
     *
     * @return The number of rows in the table.
     */
    @Override
    public int getRowCount() {
        return billsList.size();
    }

    /**
     * Returns the number of columns in the table.
     *
     * @return The number of columns in the table.
     */
    @Override
    public int getColumnCount() {
        return 7;
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
        Bill currentBill = billsList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return currentBill.id();
            case 1:
                return currentBill.nameClient();
            case 2:
                return currentBill.email();
            case 3:
                return currentBill.nameProduct();
            case 4:
                return currentBill.quantity();
            case 5:
                return currentBill.priceProduct();
            case 6:
                return currentBill.finalPrice();
        }
        return null;
    }

    /**
     * Sets the list of bills to display in the table.
     *
     * @param billsList The list of bills to display.
     */
    public void putBills(List<Bill> billsList) {
        this.billsList = billsList;
    }
}
