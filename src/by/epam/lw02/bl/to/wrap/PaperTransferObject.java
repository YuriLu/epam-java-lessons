package by.epam.lw02.bl.to.wrap;

/**
 */
public class PaperTransferObject extends WrapTransferObject {
    public String pattern;

    public PaperTransferObject(String wrap, String color, String pattern) {
        super(wrap, color);
        this.pattern = pattern;
    }
}
