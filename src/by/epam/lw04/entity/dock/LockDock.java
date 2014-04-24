package by.epam.lw04.entity.dock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 */
public class LockDock implements Dock {
    private int piersCount;
    private int maxWeight;
    private int currentWeight = 0;
    private int dockedShips = 0;
    private Lock lock = new ReentrantLock();

    public LockDock(int piersCount, int maxWeight) {
        this.piersCount = piersCount;
        this.maxWeight = maxWeight;
    }

    @Override
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

    @Override
    public boolean place(int weight) {
        int retries = 100;

        while (retries-- > 0) {
            if (tryPlace(weight)) {
                return true;
            }
        }

        return false;
    }

    @Override
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

    @Override
    public void sail() {
        lock.lock();
        try {
            dockedShips--;
        } finally {
            lock.unlock();
        }
    }

    private boolean tryDock() {
        lock.lock();
        try {
            if (dockedShips < piersCount) {
                dockedShips++;
                return true;
            }

            return false;
        } finally {
            lock.unlock();
        }
    }

    private int tryLoad(int max) {
        lock.lock();
        try {
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
        } finally {
            lock.unlock();
        }
    }

    private boolean tryPlace(int weight) {
        lock.lock();
        try {
            if (currentWeight + weight > maxWeight) {
                return false;
            }

            currentWeight += weight;
            return true;
        } finally {
            lock.unlock();
        }
    }
}
