/**
 * View
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.controller;

import by.epam.lw01.bl.*;
import by.epam.lw01.entity.Cave;
import by.epam.lw01.view.View;

import java.util.HashMap;

/**
 * Controller
 */
public class Controller {

    /**
     * View
     */
    private View view;

    /**
     * Commands set
     */
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    /**
     * Simplify configuration of controller
     *
     * @param view presentation
     * @param cave entity
     */
    public Controller(View view, Cave cave) {
        this.view = view;

        addCommand(new ShowCommand(cave));
        addCommand(new FindCommand(cave));
        addCommand(new ExpensiveCommand(cave));
    }

    /**
     * Runt main dispatch cycle
     */
    public void run() {
        while (true) {
            TransferObject inputTransferObject = view.getNextViewCommand();
            if (inputTransferObject instanceof ExitTransferObject) {
                break;
            }

            Command command = getCommand(inputTransferObject.commandId);

            TransferObject outputTransferObject = command.execute(inputTransferObject);
            view.show(outputTransferObject);
        }
    }

    /**
     * Return command by commandId
     *
     * @param commandId unique id of command
     * @return Command
     */
    private Command getCommand(String commandId) {
        return commands.get(commandId);
    }

    /**
     * Set commands
     *
     * @param command command to add
     */
    public void addCommand(Command command) {
        commands.put(command.getCommandId(), command);
    }

}
