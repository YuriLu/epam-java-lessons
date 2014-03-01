/**
 * FindTransferObject
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl;

/**
 * Transfer object with price field
 */
public class FindTransferObject extends TransferObject {

    /**
     * Index field
     */
    public int price;

    /**
     * Simplify usage of transfer object with constructor
     *
     * @param price price of treasure
     */
    public FindTransferObject(int price) {
        this.price = price;
        this.commandId = FindCommand.ID;
    }

}
