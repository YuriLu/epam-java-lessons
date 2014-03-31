/**
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.bl.factory;

import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.exception.NotFoundException;
import by.epam.lw02.bl.to.wrap.MembraneTransferObject;
import by.epam.lw02.bl.to.wrap.PaperTransferObject;
import by.epam.lw02.bl.to.wrap.PotTransferObject;
import by.epam.lw02.bl.to.wrap.WrapTransferObject;
import by.epam.lw02.entity.Wrap;
import by.epam.lw02.entity.wrap.Foil;
import by.epam.lw02.entity.wrap.Membrane;
import by.epam.lw02.entity.wrap.Paper;
import by.epam.lw02.entity.wrap.Pot;

/**
 */
public class WrapFactory {

    public Wrap factory(TransferObject transferObject) throws NotFoundException {
        WrapTransferObject wrapTransferObject = (WrapTransferObject) transferObject;
        String wrapType = wrapTransferObject.wrap;

        if (Foil.ID.equals(wrapType)) {
            return new Foil(wrapTransferObject.color);
        }

        if (Paper.ID.equals(wrapType)) {
            PaperTransferObject paperTransferObject = (PaperTransferObject) transferObject;
            return new Paper(paperTransferObject.color, paperTransferObject.pattern);
        }

        if (Membrane.ID.equals(wrapType)) {
            MembraneTransferObject membraneTransferObject = (MembraneTransferObject) transferObject;
            return new Membrane(membraneTransferObject.color, membraneTransferObject.density);
        }

        if (Pot.ID.equals(wrapType)) {
            PotTransferObject potTransferObject = (PotTransferObject) transferObject;
            return new Pot(wrapTransferObject.color, potTransferObject.form, potTransferObject.material);
        }

        throw new NotFoundException("Wrap not found " + wrapType);
    }

}
