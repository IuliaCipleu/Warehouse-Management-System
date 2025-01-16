package presentation;

import bll.ProductBLL;
import bll.PurchaseBLL;
import model.Product;
import model.Purchase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The ProductController class is responsible for controlling the flow of information between the ProductView and the ProductBLL.
 * It handles user interactions and updates the view accordingly.
 */
public class ProductController {
    private ProductView view;

    /**
     * Constructs a new ProductController object with the specified view.
     *
     * @param view the ProductView object to be controlled
     */
    public ProductController(ProductView view) {
        this.view = view;
        this.view.editDelete(new EditDelete());
        this.view.create(new Add());
        this.view.showAll(new ShowAll());
        this.view.reset(new Reset());
    }

    /**
     * Inner class that implements the ActionListener interface for handling the edit and delete actions.
     */
    class EditDelete implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the ActionEvent object that describes the user action
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getComboBox() == 0) {
                //edit case
                try {
                    ProductBLL productBLL = new ProductBLL();
                    Product product = new Product(view.getNameTextField(), view.getPriceTextField(), view.getQuantityTextField());
                    int oldId = productBLL.findProductByName(view.getNameTextField()).getId();
                    productBLL.editProduct(product, oldId);
                    view.showMessage("Product modified successfully!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    view.showErrorMessage("Error during edit!");
                }
            } else {
                if (view.getComboBox() == 1) {
                    //delete case
                    try {
                        ProductBLL productBLL = new ProductBLL();
                        Product product = productBLL.findProductByName(view.getNameTextField());
                        if (product == null) {
                            view.showErrorMessage("Product not found!");
                        } else {
                            PurchaseBLL purchaseBLL = new PurchaseBLL();
                            List<Purchase> list = purchaseBLL.findOrderByProduct(product.getId());
                            if (list != null) {
                                for (Purchase p : list) {
                                    purchaseBLL.deleteOrder(p);
                                    System.out.println(p.getId());
                                }
                                view.showErrorMessage("All the orders containing this product will be deleted!");
                                productBLL.deleteProduct(product);
                                view.showMessage("Product deleted successfully!");
                            } else {
                                productBLL.deleteProduct(product);
                                view.showMessage("Product deleted successfully!");
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.showErrorMessage("Error during delete!");
                    }
                } else {
                    view.showErrorMessage("Error at ComboBox!");
                }
            }
        }
    }

    /**
     * Inner class that implements the ActionListener interface for handling the add action.
     */
    class Add implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the ActionEvent object that describes the user action
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ProductBLL productBLL = new ProductBLL();
                Product product = new Product(view.getNameTextField(), view.getPriceTextField(), view.getQuantityTextField());
                int id = productBLL.insertProduct(product);
                if (id != -1 && id != -2) {
                    view.showMessage("Product " + view.getNameTextField() + " was successfully created!");
                } else {
                    if (id == -1) {
                        view.showErrorMessage("Product already exists!");
                    } else {
                        view.showErrorMessage("Negative values not allowed!");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                view.showErrorMessage("Error at adding product!");
            }
        }
    }

    /**
     * Inner class that implements the ActionListener interface for handling the show action.
     */
    class ShowAll implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the ActionEvent object that describes the user action
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ProductBLL productBLL = new ProductBLL();
                ArrayList<Product> products = (ArrayList<Product>) productBLL.getAllProducts();
                ProductView view2 = new ProductView(products);
                view.dispose();
                ProductController productController = new ProductController(view2);
            } catch (Exception ex) {
                ex.printStackTrace();
                view.showErrorMessage("Error during listing all!");
            }
        }
    }

    /**
     * Inner class that implements the ActionListener interface for handling the reset action.
     */
    class Reset implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the ActionEvent object that describes the user action
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            view.refresh();
        }
    }
}