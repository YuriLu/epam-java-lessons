package by.epam.lw02.bl.to;

import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.command.GetBouquetCommand;

/**
 * by.epam.lw02.bl.to
 * <p/>
 * Version 1.0
 * <p/>
 * Copyright Evgeny Shpilevsky
 */
public class GetBouquetTransferObject extends TransferObject {

    public GetBouquetTransferObject() {
        this.commandId = GetBouquetCommand.ID;
    }
}
