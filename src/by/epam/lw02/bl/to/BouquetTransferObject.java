package by.epam.lw02.bl.to;

import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.entity.Bouquet;

/**
 */
public class BouquetTransferObject extends TransferObject {

    public Bouquet bouquet;

    public BouquetTransferObject(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
}
