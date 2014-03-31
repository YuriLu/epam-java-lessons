package by.epam.lw02;

import by.epam.lw02.controller.Controller;
import by.epam.lw02.view.View;

/**
 */
public class Main {

    /**
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Controller controller = new Controller(createView());
        controller.run();
    }

    /**
     * Create default view
     *
     * @return View
     */
    private static View createView() {
        return new View();
    }

}
