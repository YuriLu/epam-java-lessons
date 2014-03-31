package by.epam.lw02.bl.to.flower;

import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.command.SelectWrapCommand;

/**
 */
public class FlowerTransferObject extends TransferObject {

    public String flower;
    public String color;

    public FlowerTransferObject(String flower, String color) {
        this.commandId = SelectWrapCommand.ID;
        this.flower = flower;
        this.color = color;
    }

}
