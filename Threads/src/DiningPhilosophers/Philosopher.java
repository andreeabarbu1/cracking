package DiningPhilosophers;

public class Philosopher implements Runnable{
    private int id;
    Chopstick leftFork, rightFork;

    public Philosopher(int id, Chopstick leftFork, Chopstick rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    @Override
    public void run() {
        if (id == 0) {
            synchronized (rightFork) {
                synchronized (leftFork) {
                    eat();
                }
            }
        } else {
            synchronized (leftFork) {
                synchronized (rightFork) {
                    eat();
                }
            }
        }
    }

/*
    @Override
    public void run() {
        if (id == 0) {
            leftFork.pickUp();
            rightFork.pickUp();
            eat();
            rightFork.putDown();
            leftFork.putDown();
        } else {
            rightFork.pickUp();
            leftFork.pickUp();
            eat();
            leftFork.putDown();
            rightFork.putDown();
        }
    }
*/
    public void eat() {
        System.out.println("Philosopher " + id + " is eating");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
