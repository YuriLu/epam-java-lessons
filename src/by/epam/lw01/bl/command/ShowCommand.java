/**
 * ShowCommand
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl.command;


import by.epam.lw01.bl.Command;
import by.epam.lw01.bl.TransferObject;
import by.epam.lw01.bl.to.ErrorTransferObject;
import by.epam.lw01.bl.to.ShowByIndexTransferObject;
import by.epam.lw01.bl.to.ShowTransferObject;
import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

public class ShowCommand implements Command {

    /**
     * unique id
     */
    public final static String ID = "show";


    /**
     * @see by.epam.lw01.bl.Command
     */
    @Override
    public TransferObject execute(TransferObject transferObject) {
        ShowByIndexTransferObject indexTO = (ShowByIndexTransferObject) transferObject;

        try {
            Treasure treasure = Cave.getInstance().getTreasure(indexTO.index);
            return new ShowTransferObject(treasure);
        } catch (Exception e) {
            return new ErrorTransferObject(e);
        }
    }

}
