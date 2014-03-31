/**
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.bl.factory;

import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.exception.NotFoundException;
import by.epam.lw02.bl.to.flower.ChamomileTransferObject;
import by.epam.lw02.bl.to.flower.FlowerTransferObject;
import by.epam.lw02.bl.to.flower.RoseTransferObject;
import by.epam.lw02.entity.Flower;
import by.epam.lw02.entity.flower.Chamomile;
import by.epam.lw02.entity.flower.Rose;

/**
 */
public class FlowerFactory {


    public Flower factory(TransferObject transferObject) throws NotFoundException {
        FlowerTransferObject flowerTO = (FlowerTransferObject) transferObject;
        String flower = flowerTO.flower;

        if (Rose.ID.equals(flower)) {
            RoseTransferObject roseTO = (RoseTransferObject) flowerTO;
            return new Rose(roseTO.color, roseTO.thornLength);
        }

        if (Chamomile.ID.equals(flower)) {
            ChamomileTransferObject chamomileTO = (ChamomileTransferObject) flowerTO;
            return new Chamomile(chamomileTO.color, chamomileTO.bladesCount);
        }

        throw new NotFoundException("Flower not found " + flower);
    }
}
