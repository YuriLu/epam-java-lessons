/**
 * ShowByIndexTransferObject
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl;

/**
 * Transfer object with index field
 */
public class ShowByIndexTransferObject extends TransferObject {

    /**
     * Index field
     */
    public int index;

    /**
     * Simplify usage of transfer object with constructor
     *
     * @param index index of treasure
     */
    public ShowByIndexTransferObject(int index) {
        this.index = index;
        this.commandId = ShowCommand.ID;
    }

}
