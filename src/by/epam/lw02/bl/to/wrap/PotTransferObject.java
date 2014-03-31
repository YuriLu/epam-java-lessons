package by.epam.lw02.bl.to.wrap;

/**
 */
public class PotTransferObject extends WrapTransferObject {
    public String material;
    public String form;

    public PotTransferObject(String wrap, String color, String form, String material) {
        super(wrap, color);
        this.form = form;
        this.material = material;
    }
}
