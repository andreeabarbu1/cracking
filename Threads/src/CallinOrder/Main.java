package CallinOrder;

public class Main {
    public static final int N = 3;

    public static void main(String[] args) {
        Thread[] threads = new Thread[N];
        Foo foo = new Foo();

        for (int i = 0; i < N; i++) {
            threads[i] = new Thread(new MyThread(i, foo));
        }
        for (int i = 0; i < N; i++) {
            threads[i].start();
        }
        for (int i = 0; i < N; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
