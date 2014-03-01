/**
 * ErrorTransferObject
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl;

/**
 * Created by ftdebugger on 3/1/14.
 */
public class ErrorTransferObject extends TransferObject {
    public Exception exception;

    public ErrorTransferObject(Exception exception) {
        this.exception = exception;
    }
}
