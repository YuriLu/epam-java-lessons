/**
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.entity.flower;

import by.epam.lw02.entity.Flower;

/**
 */
public class Chamomile extends Flower {

    public static final String ID = "chamomile";
    private int bladesCount;

    public Chamomile(String color, int bladesCount) {
        super(color);
        this.bladesCount = bladesCount;
    }

    @Override
    public String toString() {
        return color + " chamomile with " + bladesCount + " blades";
    }
}
