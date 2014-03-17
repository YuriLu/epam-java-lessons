/**
 * ExpensiveCommand
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl.command;

import by.epam.lw01.bl.Command;
import by.epam.lw01.bl.TransferObject;
import by.epam.lw01.bl.to.ShowTransferObject;
import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

/**
 * Search the most expensive treasure
 */
public class ExpensiveCommand implements Command {

    /**
     * unique id
     */
    public final static String ID = "expensive";

    /**
     * Search treasure
     */
    @Override
    public TransferObject execute(TransferObject transferObject) {
        Treasure expensive = null;

        for (Treasure treasure : Cave.getInstance()) {
            if (expensive == null || treasure.getPrice() > expensive.getPrice()) {
                expensive = treasure;
            }
        }

        return new ShowTransferObject(expensive);
    }

}
