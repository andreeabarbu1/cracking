package DiningPhilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    // chopstick object
    private Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}
