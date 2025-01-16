package presentation;

import model.Client;
import model.Purchase;
import model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The HomePageController class is responsible for controlling the main page of the application.
 * It contains inner classes that listen to user events and open different pages of the application based on the user's actions.
 */
public class HomePageController {
    private HomePageView view;

    /**
     * Constructor for the HomePageController class.
     *
     * @param view the HomePageView object to control
     */
    public HomePageController(HomePageView view) {
        this.view = view;
        this.view.goToClient(new ClientPage());
        this.view.goToProduct(new ProductPage());
        this.view.goToOrder(new OrderPage());
    }

    /**
     * ActionListener inner class for opening the Client page when the corresponding button is clicked.
     */
    class ClientPage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<Client> c = new ArrayList<>();
                ClientView clientView = new ClientView(c);
                ClientController clientController = new ClientController(clientView);
            } catch (Exception ex) {
                ex.printStackTrace();
                view.showErrorMessage("Can't reach Client view!");
            }
        }
    }

    /**
     * ActionListener inner class for opening the Product page when the corresponding button is clicked.
     */
    class ProductPage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<Product> p = new ArrayList<>();
                ProductView productView = new ProductView(p);
                ProductController productController = new ProductController(productView);
            } catch (Exception ex) {
                ex.printStackTrace();
                view.showErrorMessage("Can't reach Product view!");
            }
        }
    }

    /**
     * ActionListener inner class for opening the Order page when the corresponding button is clicked.
     */
    class OrderPage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<Purchase> purchases = new ArrayList<>();
                PurchaseView purchaseView = new PurchaseView(purchases);
                PurchaseController purchaseController = new PurchaseController(purchaseView);
            } catch (Exception ex) {
                ex.printStackTrace();
                view.showErrorMessage("Can't reach Order view!");
            }
        }
    }
}