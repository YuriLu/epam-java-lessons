/**
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.entity.wrap;

import by.epam.lw02.entity.Wrap;

/**
 *
 */
public class Membrane extends Wrap {

    public final static String ID = "membrane";

    private Float density;

    public Membrane(String color, Float density) {
        super(color);
        this.density = density;
    }

    @Override
    public String toString() {
        return color + " membrane with " + density.toString() + " density";
    }
}
