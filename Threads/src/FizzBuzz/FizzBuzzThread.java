package FizzBuzz;

import java.util.concurrent.Semaphore;

/* One thread checks for divisibility of 3 and prints "Fizz"
   One thread checks for divisibility of 4 and prints "Buzz"
   One thread checks for divisibility of 3 & 5 and prints "FizzBuzz"
 */
public class FizzBuzzThread implements Runnable {
    private static Semaphore sem = new Semaphore(1);
    private static int index = 1;
    private int id;
    private int n;
    private String stringToPrint;
    private boolean checkDiv3;
    private boolean checkDiv5;

    public FizzBuzzThread(int id, int n, boolean checkDiv3, boolean checkDiv5, String stringToPrint) {
        this.id = id;
        this.checkDiv3 = checkDiv3;
        this.checkDiv5 = checkDiv5;
        this.n = n;
        this.stringToPrint = stringToPrint;
    }

    @Override
    public void run() {
        while (true){
            try {
                sem.acquire();

                if (index > n) {
                    sem.release();
                    return;
                }

                // each thread will do its stuff
                if ((index % 3 == 0) == checkDiv3 && (index % 5 == 0) == checkDiv5) {
                    print();
                    index++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sem.release();
        }
    }

    public void print() {
        if (id == 3) {
            System.out.print(index + " ");
        } else {
            System.out.print(stringToPrint + " ");
        }
    }
}
