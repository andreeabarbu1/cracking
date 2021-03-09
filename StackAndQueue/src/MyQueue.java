import java.util.NoSuchElementException;

public class MyQueue<E> {
    private QueueNode<E> head = null, tail = null;

    public E remove() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public E peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public void add(E data) {
        QueueNode newNode = new QueueNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public boolean isEmpty() {
        return head == null;
    }

    private class QueueNode<E> {
        private E data;
        private QueueNode next;

        QueueNode (E data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //System.out.println(queue.pop());
    }
}
