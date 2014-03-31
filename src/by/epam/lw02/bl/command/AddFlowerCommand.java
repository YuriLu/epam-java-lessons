package by.epam.lw02.bl.command;

import by.epam.lw02.bl.Builder;
import by.epam.lw02.bl.Command;
import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.exception.NotFoundException;
import by.epam.lw02.bl.to.AppendedTransferObject;
import by.epam.lw02.bl.to.ExceptionTransferObject;
import by.epam.lw02.bl.to.flower.FlowerTransferObject;

/**
 *
 */
public class AddFlowerCommand implements Command {

    public final static String ID = "add-flower";

    @Override
    public TransferObject execute(TransferObject transferObject) {
        FlowerTransferObject flowerTO = (FlowerTransferObject) transferObject;

        try {
            Builder.getInstance().addFlower(flowerTO);
            return new AppendedTransferObject();
        } catch (NotFoundException e) {
            return new ExceptionTransferObject(e);
        }
    }
}
