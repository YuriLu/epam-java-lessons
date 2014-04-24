package by.epam.lw04;

import by.epam.lw04.entity.Ship;
import by.epam.lw04.entity.dock.Dock;
import by.epam.lw04.entity.dock.LockDock;
import by.epam.lw04.entity.dock.SynchronizedDock;
import by.epam.lw04.thread.ShipThread;

import java.util.Random;

/**
 */
public class Main {

    private static void emulateWork(Dock dock) {
        Thread[] threads = new Thread[20];
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int maxWeight = 10 + random.nextInt(50);
            int currentWeight = random.nextInt(maxWeight);

            Ship ship = new Ship(maxWeight, currentWeight);
            threads[i] = new Thread(new ShipThread(dock, ship));
        }

        // run
        for (int i = 0; i < 20; i++) {
            threads[i].run();
        }

        // wait
        for (int i = 0; i < 20; i++) {
            while (threads[i].isAlive()) {
                System.out.println("waiting");
            }
        }
    }

    /**
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Synchronized variant");
        emulateWork(new SynchronizedDock(5, 1000));
        System.out.println("Lock variant");
        emulateWork(new LockDock(5, 1000));
    }


}
