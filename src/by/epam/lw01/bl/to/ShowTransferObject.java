/**
 * ShowTransferObject
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl.to;

import by.epam.lw01.bl.TransferObject;
import by.epam.lw01.entity.Treasure;

/**
 * ShowTransferObject
 */
public class ShowTransferObject extends TransferObject {

    /**
     * Treasure
     */
    public Treasure treasure;

    /**
     * Create transfer object with treasure inside
     *
     * @param treasure Treasure
     */
    public ShowTransferObject(Treasure treasure) {
        this.treasure = treasure;
    }
}
