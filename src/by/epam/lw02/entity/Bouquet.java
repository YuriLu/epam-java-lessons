/**
 * Version 1.0
 *
 * Copyright Evgeny Shpilevsky
 */
package by.epam.lw02.entity;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class Bouquet {

    private Wrap wrap;
    private List<Flower> flowers = new LinkedList<Flower>();

    /**
     * Add flower
     *
     * @param flower some flower
     */
    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void setWrap(Wrap wrap) {
        this.wrap = wrap;
    }

    public Wrap getWrap() {
        return wrap;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }
}
