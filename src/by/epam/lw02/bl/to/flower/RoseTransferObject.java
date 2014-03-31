package by.epam.lw02.bl.to.flower;

import by.epam.lw02.entity.flower.Rose;

/**
 */
public class RoseTransferObject extends FlowerTransferObject {

    public final int thornLength;

    public RoseTransferObject(String color, int thornLength) {
        super(Rose.ID, color);
        this.thornLength = thornLength;
    }

}
