package by.epam.lw02.bl;

import by.epam.lw02.entity.Bouquet;
import by.epam.lw02.entity.Flower;
import by.epam.lw02.entity.Wrap;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class Builder {

    private FlowerFactory flowerFactory = new FlowerFactory();
    private WrapFactory wrapFactory = new WrapFactory();
    private Wrap wrap;
    private List<Flower> flowers = new LinkedList<Flower>();

    public void setWrap(Wrap wrap) {
        this.wrap = wrap;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public Bouquet getBouquet() {
        Bouquet bouquet = new Bouquet();
        bouquet.setWrap(wrap);

        for (Flower flower : flowers) {
            bouquet.addFlower(flower);
        }

        wrap = null;
        flowers.clear();

        return bouquet;
    }


}
