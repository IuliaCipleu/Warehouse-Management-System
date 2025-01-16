package start;

import presentation.*;

/**
 * @author Iulia-Olivia Cipleu
 * @version 1.0
 * @since 09.05.2023
 */
public class Main {
    public static void main(String[] args) {
        HomePageView view = new HomePageView();
        HomePageController controller = new HomePageController(view);
    }
}