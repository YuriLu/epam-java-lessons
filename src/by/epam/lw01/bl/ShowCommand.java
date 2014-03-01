/**
 * ShowCommand
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl;


import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

public class ShowCommand implements Command {

    /**
     * unique id
     */
    public final static String ID = "show";

    /**
     * Cave
     */
    private Cave cave;

    /**
     * @param cave Cave
     */
    public ShowCommand(Cave cave) {
        this.cave = cave;
    }

    /**
     * @see by.epam.lw01.bl.Command
     */
    @Override
    public TransferObject execute(TransferObject transferObject) {
        ShowByIndexTransferObject indexTO = (ShowByIndexTransferObject) transferObject;

        try {
            Treasure treasure = cave.getTreasure(indexTO.index);
            return new ShowTransferObject(treasure);
        } catch (Exception e) {
            return new ErrorTransferObject(e);
        }
    }

    /**
     * @see by.epam.lw01.bl.Command
     */
    @Override
    public String getCommandId() {
        return ID;
    }
}
