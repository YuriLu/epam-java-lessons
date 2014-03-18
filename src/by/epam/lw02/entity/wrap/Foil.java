/**
 * Foil
 *
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.entity.wrap;

import by.epam.lw02.entity.Wrap;

/**
 * Foil
 */
public class Foil extends Wrap {

    public final static String ID = "foil";

    public Foil(String color) {
        super(color);
    }

    @Override
    public String toString() {
        return color + " foil";
    }
}
