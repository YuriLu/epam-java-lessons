/**
 * Main file
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01;

import by.epam.lw01.controller.Controller;
import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;
import by.epam.lw01.view.View;

import java.util.Random;

/**
 * Entry point to application
 */
public class Main {

    /**
     * Count of treasures
     */
    private static final int treasureCount = 100;

    /**
     * Max price of treasure
     */
    private static final int maxPrice = 100;

    /**
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        createCave();
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

    /**
     * Create mock of cave
     *
     * @return Cave
     */
    private static Cave createCave() {
        Cave cave = Cave.getInstance();

        Random random = new Random();

        for (int i = 0; i < treasureCount; i++) {
            cave.addTreasure(new Treasure(1 + random.nextInt(maxPrice)));
        }

        return cave;
    }

}

