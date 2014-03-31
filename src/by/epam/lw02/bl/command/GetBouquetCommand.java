package by.epam.lw02.bl.command;

import by.epam.lw02.bl.Builder;
import by.epam.lw02.bl.Command;
import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.to.BouquetTransferObject;

/**
 */
public class GetBouquetCommand implements Command {


    public final static String ID = "get-bouquet";

    @Override
    public TransferObject execute(TransferObject transferObject) {
        return new BouquetTransferObject(Builder.getInstance().getBouquet());
    }
}
