package FizzBuzz;

import java.util.concurrent.Semaphore;

public class Main {
    private static final int N = 100;

    public static void main(String[] args) {

        Thread[] threads = {new Thread(new FizzBuzzThread(0, N, true, false, "Fizz")),
                    new Thread(new FizzBuzzThread(1, N, false, true, "Buzz")),
                    new Thread(new FizzBuzzThread(2, N, true, true, "FizzBuzz")),
                    new Thread(new FizzBuzzThread(3, N, false, false, ""))};

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
