/**
 * ErrorTransferObject
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl.to;

import by.epam.lw01.bl.TransferObject;

/**
 * Created by ftdebugger on 3/1/14.
 */
public class ErrorTransferObject extends TransferObject {

    /**
     * Exception
     */
    public Exception exception;

    /**
     * Simplify create of TO
     *
     * @param exception exception for transfer
     */
    public ErrorTransferObject(Exception exception) {
        this.exception = exception;
    }
}
