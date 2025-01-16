package presentation;

import model.Client;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the table model used to display a list of clients in a JTable.
 */
public class ClientTableModel extends AbstractTableModel {
    /**
     * The list of clients to display.
     */
    private List<Client> clientsList = new ArrayList<>();

    /**
     * Returns the number of rows in the table.
     *
     * @return The number of rows in the table.
     */
    @Override
    public int getRowCount() {
        return clientsList.size();
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
        Client currentClient = clientsList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return currentClient.getId();
            case 1:
                return currentClient.getName();
            case 2:
                return currentClient.getAddress();
            case 3:
                return currentClient.getEmail();
        }
        return null;
    }

    /**
     * Sets the list of clients to display in the table.
     *
     * @param clientsList The list of products to display.
     */
    public void putClients(List<Client> clientsList) {
        this.clientsList = clientsList;
    }
}