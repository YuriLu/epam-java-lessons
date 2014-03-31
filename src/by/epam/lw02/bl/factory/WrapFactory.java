/**
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.bl.factory;

import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.exception.NotFoundException;
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
            return new Paper(wrapTransferObject.color, wrapTransferObject.pattern);
        }

        if (Membrane.ID.equals(wrapType)) {
            return new Membrane(wrapTransferObject.color, wrapTransferObject.density);
        }

        if (Pot.ID.equals(wrapType)) {
            return new Pot(wrapTransferObject.color, wrapTransferObject.form, wrapTransferObject.material);
        }

        throw new NotFoundException("Wrap not found " + wrapType);
    }

}
