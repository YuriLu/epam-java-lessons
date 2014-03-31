package by.epam.lw02.bl;

import by.epam.lw02.bl.exception.NotFoundException;
import by.epam.lw02.bl.factory.FlowerFactory;
import by.epam.lw02.bl.factory.WrapFactory;
import by.epam.lw02.bl.to.flower.FlowerTransferObject;
import by.epam.lw02.bl.to.wrap.WrapTransferObject;
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
    private static Builder instance;

    private Builder() {

    }

    public void setWrap(Wrap wrap) {
        this.wrap = wrap;
    }

    public void setWrap(WrapTransferObject transferObject) throws NotFoundException {
        Wrap wrap = wrapFactory.factory(transferObject);
        setWrap(wrap);
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addFlower(FlowerTransferObject transferObject) throws NotFoundException {
        Flower flower = flowerFactory.factory(transferObject);
        addFlower(flower);
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

    public static Builder getInstance() {
        if (instance == null) {
            instance = new Builder();
        }

        return instance;
    }
}
