/**
 * Cave
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw01.entity;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Cave hold information about treasures
 */
public class Cave implements Iterable<Treasure> {

    /**
     * List of treasures
     */
    private LinkedList<Treasure> treasures = new LinkedList<Treasure>();

    /**
     * Add treasure to cave
     *
     * @param treasure new treasure
     */
    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    /**
     * Get treasure by index
     *
     * @param index index
     * @return Treasure
     */
    public Treasure getTreasure(int index) {
        return treasures.get(index);
    }

    /**
     * @return treasures
     */
    public LinkedList<Treasure> getTreasures() {
        return treasures;
    }

    /**
     * Size of treasures
     *
     * @return int
     */
    public int size() {
        return treasures.size();
    }

    /**
     * Simplify access to treasures
     *
     * @return Treasure iterator
     */
    @Override
    public Iterator<Treasure> iterator() {
        return treasures.iterator();
    }
}
