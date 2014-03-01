/**
 * ExpensiveCommand
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl;

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
     * Cave
     */
    private Cave cave;

    /**
     * @param cave Cave
     */
    public ExpensiveCommand(Cave cave) {
        this.cave = cave;
    }

    /**
     * Search treasure
     */
    @Override
    public TransferObject execute(TransferObject transferObject) {
        Treasure expensive = null;

        for (Treasure treasure : cave) {
            if (expensive == null || treasure.getPrice() > expensive.getPrice()) {
                expensive = treasure;
            }
        }

        return new ShowTransferObject(expensive);
    }

    /**
     * @see Command
     */
    @Override
    public String getCommandId() {
        return ID;
    }
}
