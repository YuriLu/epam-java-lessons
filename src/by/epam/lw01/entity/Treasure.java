/**
 * Treasure
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.entity;

/**
 * Describe treasure and it properties
 */
public class Treasure {

    /**
     * Treasure price
     */
    private int price;

    /**
     * @param price treasure price
     */
    public Treasure(int price) {
        this.price = price;
    }

    /**
     * Return price of treasure
     *
     * @return int
     */
    public int getPrice() {
        return price;
    }
}
