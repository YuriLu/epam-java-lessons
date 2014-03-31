/**
 * View
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.controller;

import by.epam.lw02.bl.Command;
import by.epam.lw02.bl.TransferObject;
import by.epam.lw02.bl.command.AddFlowerCommand;
import by.epam.lw02.bl.command.GetBouquetCommand;
import by.epam.lw02.bl.command.SelectWrapCommand;
import by.epam.lw02.view.View;

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

        addCommand(SelectWrapCommand.ID, new SelectWrapCommand());
        addCommand(AddFlowerCommand.ID, new AddFlowerCommand());
        addCommand(GetBouquetCommand.ID, new GetBouquetCommand());
    }

    /**
     * Run main dispatch cycle
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
    private void addCommand(String id, Command command) {
        commands.put(id, command);
    }

}
