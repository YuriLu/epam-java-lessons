/**
 * View
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.controller;

import by.epam.lw01.bl.Command;
import by.epam.lw01.bl.TransferObject;
import by.epam.lw01.bl.command.ExpensiveCommand;
import by.epam.lw01.bl.command.FindCommand;
import by.epam.lw01.bl.command.ShowCommand;
import by.epam.lw01.view.View;

import java.util.HashMap;
import java.util.Map;

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
    private Map<String, Command> commands = new HashMap<String, Command>();

    /**
     * Simplify configuration of controller
     *
     * @param view presentation
     */
    public Controller(View view) {
        this.view = view;

        addCommand(ShowCommand.ID, new ShowCommand());
        addCommand(FindCommand.ID, new FindCommand());
        addCommand(ExpensiveCommand.ID, new ExpensiveCommand());
    }

    /**
     * Runt main dispatch cycle
     */
    public void run() {
        while (true) {
            TransferObject inputTransferObject = view.getNextViewCommand();

            if (inputTransferObject == null) {
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
    public void addCommand(String id, Command command) {
        commands.put(id, command);
    }

}
