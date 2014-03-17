/**
 * ExpensiveTransferObject
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl.to;

import by.epam.lw01.bl.TransferObject;
import by.epam.lw01.bl.command.ExpensiveCommand;

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
