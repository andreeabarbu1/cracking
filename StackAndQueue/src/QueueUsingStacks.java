/* implements a queue using two stacks */

public class QueueUsingStacks<E> {
    MyStack<E> store, inOrder;

    QueueUsingStacks() {
        store = new MyStack<>();
        inOrder = new MyStack<>();
    }

    public void push(E data) {
        store.push(data);
    }

    public E pop() {
        if (inOrder.isEmpty()) {
            // reverse the stack which stores the elements
            reverseStack();
        }
       return inOrder.pop();
    }

    public E peek() {
        if (inOrder.isEmpty()) {
            // reverse the stack which stores the elements
            reverseStack();
        }
        return inOrder.peek();
    }

    private void reverseStack() {
        while (!store.isEmpty()) {
            inOrder.push(store.pop());
        }
    }
}
