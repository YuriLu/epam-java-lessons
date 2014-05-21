package by.epam.lw05.entity;

import java.util.Date;

/**
 */
public class Tariff {

    private int ID;
    private String title;
    private String type;
    private Date started;
    private boolean active;
    private int price;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", started=" + started +
                ", active=" + active +
                ", price=" + price +
                '}';
    }
}
