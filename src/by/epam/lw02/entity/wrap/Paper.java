/**
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.entity.wrap;

import by.epam.lw02.entity.Wrap;

/**
 */
public class Paper extends Wrap {

    public final static String ID = "paper";

    private String pattern;

    public Paper(String color, String pattern) {
        super(color);
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return color + " paper with " + pattern + " pattern";
    }
}
