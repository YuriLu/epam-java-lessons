package by.epam.lw05.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * by.epam.lw05.thread
 * <p/>
 * Version 1.0
 * <p/>
 * Copyright Evgeny Shpilevsky
 */
public class ThreadPool {

    private int threadsCount;
    private List<Workload> workloadList = new LinkedList<Workload>();
    private InnerThread[] innerThreads;
    private Thread[] threads;
    private Lock lock = new ReentrantLock();

    class InnerThread implements Runnable {

        private boolean work = true;
        private boolean stopped = false;

        @Override
        public void run() {

            while (work) {
                Workload workload;

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();
                try {
                    if (workloadList.size() > 0) {
                        workload = workloadList.get(0);
                        workloadList.remove(0);
                    } else {
                        continue;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                } finally {
                    lock.unlock();
                }

                if (workload != null) {
                    try {
                        workload.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            this.stopped = true;
        }

        public void stop() {
            work = false;
        }

        public boolean isStopped() {
            return stopped;
        }
    }

    public ThreadPool(int threadsCount) {
        this.threadsCount = threadsCount;
        this.threads = new Thread[threadsCount];
        this.innerThreads = new InnerThread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            System.out.println("Create thread " + i);
            innerThreads[i] = new InnerThread();
            threads[i] = new Thread(innerThreads[i]);
            threads[i].start();
        }
    }

    public void addWorkload(Workload workload) {
        lock.lock();
        try {
            workloadList.add(workload);
        } finally {
            lock.unlock();
        }
    }

    public void waitAndStop() {
        while (true) {
            lock.lock();
            try {
                if (workloadList.isEmpty()) {
                    for (int i = 0; i < threadsCount; i++) {
                        innerThreads[i].stop();
                        while (!innerThreads[i].isStopped()) {
                            Thread.sleep(1);
                        }
                    }

                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
