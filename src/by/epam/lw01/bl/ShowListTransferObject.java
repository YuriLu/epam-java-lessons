/**
 * ShowListTransferObject
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl;

import by.epam.lw01.entity.Treasure;

/**
 * ShowListTransferObject
 */
public class ShowListTransferObject extends TransferObject {

    /**
     * Treasure
     */
    public Treasure[] treasures;

    /**
     * Common price of treasures
     */
    public int price;

    /**
     * Create transfer object with treasures inside
     *
     * @param treasures Treasure
     */
    public ShowListTransferObject(Treasure[] treasures, int price) {
        this.treasures = treasures;
        this.price = price;
    }
}
