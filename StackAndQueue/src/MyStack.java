import java.util.EmptyStackException;

/*LIFO*/

public class MyStack <E> {
    private NodeStack<E> top = null;
    private int length = 0;

    public E pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        E data = top.data;
        top = top.next;
        length--;
        return data;
    }

    public E peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void push(E data) {
        NodeStack<E> newNode = new NodeStack<>(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        length++;
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    public int getLength() {
        return length;
    }

    public void print() {
        NodeStack<E> currentNode = top;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    private static class NodeStack<E> {
        private E data;
        private NodeStack<E> next;

        NodeStack (E data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //System.out.println(stack.pop());
    }
}
