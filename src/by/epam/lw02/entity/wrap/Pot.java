/**
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.entity.wrap;

import by.epam.lw02.entity.Wrap;

/**
 */
public class Pot extends Wrap {

    public final static String ID = "pot";

    private String form;
    private String material;

    public Pot(String color, String form, String material) {
        super(color);
        this.form = form;
        this.material = material;
    }

    @Override
    public String toString() {
        return color + " " + form + " pot created from " + material;
    }
}
