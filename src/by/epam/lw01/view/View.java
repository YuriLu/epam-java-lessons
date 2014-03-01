/**
 * View
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.view;

import by.epam.lw01.bl.*;
import by.epam.lw01.entity.Treasure;

/**
 * Data representation
 */
public class View {

    private int iteration = 0;

    /**
     * @return next command
     */
    public TransferObject getNextViewCommand() {
        TransferObject result;

        if (iteration < 100) {
            System.out.print(String.format("Cost of treasure %d: ", iteration));
            result = new ShowByIndexTransferObject(iteration);
        } else if (iteration == 100) {
            System.out.print("Give treasures for 1000: ");
            result = new FindTransferObject(1000);
        } else if (iteration == 101) {
            System.out.print("Most expensive: ");
            result = new ExpensiveTransferObject();
        } else {
            result = new ExitTransferObject();
        }

        iteration++;

        return result;
    }

    /**
     * Represent transfer object
     *
     * @param transferObject transfer object
     */
    public void show(TransferObject transferObject) {
        if (transferObject instanceof ShowTransferObject) {
            showTreasure(((ShowTransferObject) transferObject).treasure);
        } else if (transferObject instanceof ShowListTransferObject) {
            ShowListTransferObject showList = (ShowListTransferObject) transferObject;
            showTreasures(showList.treasures, showList.price);
        }
    }

    /**
     * Output treasure
     *
     * @param treasure treasures
     */
    private void showTreasure(Treasure treasure) {
        System.out.println(treasure.getPrice());
    }

    /**
     * Output treasures
     *
     * @param treasures treasures
     */
    private void showTreasures(Treasure[] treasures, int price) {
        for (int index = 0; index < treasures.length; index++) {
            if (index > 0) {
                System.out.print(" + ");
            }

            System.out.print(treasures[index].getPrice());
        }

        System.out.print(" = ");
        System.out.println(price);
    }
}
