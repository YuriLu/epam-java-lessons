/**
 * ExpensiveTransferObject
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl;

/**
 * ExpensiveTransferObject
 */
public class ExpensiveTransferObject extends TransferObject {

    /**
     * Constructor
     */
    public ExpensiveTransferObject() {
        this.commandId = ExpensiveCommand.ID;
    }

}
