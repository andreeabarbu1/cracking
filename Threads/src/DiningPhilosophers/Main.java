package DiningPhilosophers;

public class Main {
    public static final int N = 6;

    public static void main(String[] args) {
        Thread[] philosophers = new Thread[N];
        Chopstick[] chopsticks = new Chopstick[N];

        System.out.println("Philosophers are eating!");

        for (int i = 0; i < N; i++) {
            chopsticks[i] = new Chopstick();
        }
        for (int i = 0; i < N; i++) {
            philosophers[i] = new Thread(new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % N]));
        }
        for (int i = 0; i < N; i++) {
            philosophers[i].start();
        }
        for (int i = 0; i < N; i++) {
            try {
                philosophers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
