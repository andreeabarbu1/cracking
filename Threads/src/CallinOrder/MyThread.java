package CallinOrder;

public class MyThread implements Runnable{
    private int id;
    Foo foo;
    public MyThread(int id, Foo foo) {
        this.id = id;
        this.foo = foo;
    }

    @Override
    public void run() {
        switch (id) {
            case 0: {
                foo.first();
                break;
            }
            case 1: {
                foo.second();
                break;
            }
            case 2: {
                foo.third();
                break;
            }
        }
    }
}
