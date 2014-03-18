/**
 * Command interface
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.bl;

/**
 * Implements common command operations
 */
public interface Command {

    /**
     * Execute command
     *
     * @param transferObject Input transfer object
     * @return Output transfer object
     */
    public TransferObject execute(TransferObject transferObject);

}
