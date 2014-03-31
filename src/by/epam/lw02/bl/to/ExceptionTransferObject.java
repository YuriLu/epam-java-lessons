package by.epam.lw02.bl.to;

import by.epam.lw02.bl.TransferObject;

/**
 */
public class ExceptionTransferObject extends TransferObject {

    public Exception exception;

    public ExceptionTransferObject(Exception exception) {
        this.exception = exception;
    }
}
