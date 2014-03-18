package by.epam.lw02.bl.to;

import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.command.SelectWrapCommand;

/**
 */
public class WrapTransferObject extends TransferObject {

    public String wrap;
    public String color;
    public String pattern;
    public String material;
    public String form;
    public Float density;

    public WrapTransferObject() {
        this.commandId = SelectWrapCommand.ID;
    }

    public WrapTransferObject(String wrap, String color) {
        this();
        this.wrap = wrap;
        this.color = color;
    }

    public WrapTransferObject(String wrap, String color, String pattern) {
        this(wrap, color);
        this.pattern = pattern;
    }

    public WrapTransferObject(String wrap, String color, Float density) {
        this(wrap, color);
        this.density = density;
    }

    public WrapTransferObject(String wrap, String color, String form, String material) {
        this(wrap, color);
        this.form = form;
        this.material = material;
    }


}
