package by.epam.lw02.bl.to.flower;

import by.epam.lw02.entity.flower.Chamomile;

/**
 */
public class ChamomileTransferObject extends FlowerTransferObject {

    public int bladesCount;

    public ChamomileTransferObject(String color, int bladesCount) {
        super(Chamomile.ID, color);
        this.bladesCount = bladesCount;
    }
}
