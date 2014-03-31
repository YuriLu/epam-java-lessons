/**
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.entity.flower;

import by.epam.lw02.entity.Flower;

/**
 * Rose
 */
public class Rose extends Flower {

    public static final String ID = "rose";

    private int thornLength;

    public Rose(String color, int thornLength) {
        super(color);
        this.thornLength = thornLength;
    }

    @Override
    public String toString() {
        return color + " rose with " + thornLength + " thorn";
    }
}
