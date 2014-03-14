/**
 * FindCommand
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.bl;

import by.epam.lw01.entity.Cave;
import by.epam.lw01.entity.Treasure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Determine the number of each item to include in a collection so that the
 * total price is less than or equal to a given limit and the total value is as
 * large as possible
 */
public class FindCommand implements Command {

    /**
     * unique id
     */
    public final static String ID = "find";

    /**
     * Cave
     */
    private Cave cave;

    /**
     * @param cave Cave
     */
    public FindCommand(Cave cave) {
        this.cave = cave;
    }

    /**
     * Search treasures for specified costs
     */
    @Override
    public TransferObject execute(TransferObject transferObject) {
        int price = ((FindTransferObject) transferObject).price;

        Treasure[] treasures = cave.getTreasures()
                .toArray(new Treasure[cave.size()]);

        Arrays.sort(treasures, new Comparator<Treasure>() {
            @Override
            public int compare(Treasure a, Treasure b) {
                return b.getPrice() - a.getPrice();
            }
        });

        List<Treasure> used = new LinkedList<Treasure>();

        int currentPrice = 0;
        for (Treasure treasure : treasures) {
            if (currentPrice + treasure.getPrice() <= price) {
                currentPrice += treasure.getPrice();
                used.add(treasure);
            }
        }

        Treasure[] result = used.toArray(new Treasure[used.size()]);
        return new ShowListTransferObject(result, currentPrice);
    }

}
