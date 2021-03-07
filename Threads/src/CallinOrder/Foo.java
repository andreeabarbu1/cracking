package CallinOrder;
import java.util.concurrent.Semaphore;

public class Foo {
    public Semaphore sem1, sem2;

    public Foo() {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(1);
        try {
            sem1.acquire();
            sem2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first() {
        // code
        System.out.println("Thread A is first");
        sem1.release();
    }

    public void second() {
        try {
            sem1.acquire();
            //sem1.release();
            // code
            System.out.println("Thread B is second");
            // let third
            sem2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void third() {
        try {
            sem2.acquire();
            //sem2.release();
            // code
            System.out.println("Thread C is third");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
  ThreadA will call first, ThreadB will call second
  ThreadC will call third
  Design a mechanism to ensure that first is called
  before second and second is called before third

  *Barrier*
 */