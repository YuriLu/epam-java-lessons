package by.epam.lw04.entity.dock;

/**
 */
public class SynchronizedDock implements Dock {
    private int piersCount;
    private int maxWeight;
    private int currentWeight = 0;
    private int dockedShips = 0;

    public SynchronizedDock(int piersCount, int maxWeight) {
        this.piersCount = piersCount;
        this.maxWeight = maxWeight;
    }

    public int load(int max) {
        int retries = 100;

        while (retries-- > 0) {
            int cargo = tryLoad(max);
            if (cargo > 0) {
                return cargo;
            }
        }

        return 0;
    }

    public boolean place(int weight) {
        int retries = 100;

        while (retries-- > 0) {
            if (tryPlace(weight)) {
                return true;
            }
        }

        return false;
    }

    public boolean dock() {
        while (!this.tryDock()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                return false;
            }
        }

        return true;
    }

    public synchronized void sail() {
        dockedShips--;
    }

    private synchronized boolean tryDock() {
        if (dockedShips < piersCount) {
            dockedShips++;
            return true;
        }

        return false;
    }

    private synchronized int tryLoad(int max) {
        if (currentWeight >= max) {
            currentWeight -= max;
            return max;
        }

        if (max > currentWeight) {
            int weight = currentWeight;
            currentWeight = 0;
            return weight;
        }

        return 0;
    }

    private synchronized boolean tryPlace(int weight) {
        if (currentWeight + weight > maxWeight) {
            return false;
        }

        currentWeight += weight;
        return true;
    }
}
