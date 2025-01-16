package presentation;

import model.Product;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the table model used to display a list of products in a JTable.
 */
public class ProductTableModel extends AbstractTableModel {
    /**
     * The list of products to display.
     */
    private List<Product> productsList = new ArrayList<>();

    /**
     * Returns the number of rows in the table.
     *
     * @return The number of rows in the table.
     */
    @Override
    public int getRowCount() {
        return productsList.size();
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
        Product currentProduct = (Product) productsList.toArray()[rowIndex];
        switch (columnIndex) {
            case 0:
                return currentProduct.getId();
            case 1:
                return currentProduct.getName();
            case 2:
                return currentProduct.getPrice();
            case 3:
                return currentProduct.getQuantity();
        }
        return null;
    }

    /**
     * Sets the list of products to display in the table.
     *
     * @param productsList The list of products to display.
     */
    public void setProducts(List<Product> productsList) {
        this.productsList = productsList;
    }
}
