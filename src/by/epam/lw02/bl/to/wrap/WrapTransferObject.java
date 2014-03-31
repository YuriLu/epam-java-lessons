package by.epam.lw02.bl.to.wrap;

import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.command.SelectWrapCommand;

/**
 */
public class WrapTransferObject extends TransferObject {

    public String wrap;
    public String color;

    public WrapTransferObject() {
        this.commandId = SelectWrapCommand.ID;
    }

    public WrapTransferObject(String wrap, String color) {
        this();
        this.wrap = wrap;
        this.color = color;
    }


}
