/**
 * View
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.view;

import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.to.AppendedTransferObject;
import by.epam.lw02.bl.to.BouquetTransferObject;
import by.epam.lw02.bl.to.ExceptionTransferObject;
import by.epam.lw02.bl.to.GetBouquetTransferObject;
import by.epam.lw02.bl.to.flower.ChamomileTransferObject;
import by.epam.lw02.bl.to.flower.RoseTransferObject;
import by.epam.lw02.bl.to.wrap.WrapTransferObject;
import by.epam.lw02.entity.Flower;

/**
 * Data representation
 */
public class View {

    private int iteration = 0;

    /**
     * @return next command
     */
    public TransferObject getNextViewCommand() {
        TransferObject result;

        if (iteration == 0) {
            result = new WrapTransferObject("Plutonium", "");
        } else if (iteration == 1) {
            result = new ChamomileTransferObject("white", 12);
        } else if (iteration >= 2 && iteration <= 5) {
            result = new RoseTransferObject("red", 1);
        } else if (iteration > 5) {
            result = new GetBouquetTransferObject();
        } else {
            result = null;
        }

        iteration++;

        return result;
    }

    /**
     * Represent transfer object
     *
     * @param transferObject transfer object
     */
    public void show(TransferObject transferObject) {
        if (transferObject instanceof AppendedTransferObject) {
            System.out.println("Appended");
        } else if (transferObject instanceof BouquetTransferObject) {
            System.out.println("Bouquet ready");
            BouquetTransferObject bouquetTransferObject = (BouquetTransferObject) transferObject;
            System.out.println("Wrap " + bouquetTransferObject.bouquet.getWrap());

            for (Flower flower : bouquetTransferObject.bouquet.getFlowers()) {
                System.out.println("Flower " + flower);
            }

        } else if (transferObject instanceof ExceptionTransferObject) {
            System.out.println(((ExceptionTransferObject) transferObject).exception.getMessage());
        }
    }

}
