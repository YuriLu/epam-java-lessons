package by.epam.lw02.bl.to.wrap;

/**
 */
public class MembraneTransferObject extends WrapTransferObject {
    public Float density;

    public MembraneTransferObject(String wrap, String color, Float density) {
        super(wrap, color);
        this.density = density;
    }
}
