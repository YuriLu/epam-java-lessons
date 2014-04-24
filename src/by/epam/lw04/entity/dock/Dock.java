package by.epam.lw04.entity.dock;

/**
 */
public interface Dock {
    public int load(int max);

    public boolean place(int weight);

    public boolean dock();

    public void sail();
}
