/*
    a program to sort a stack (the smallest items are on the top),
    using an additional stack
 */
public class SortStack {
    MyStack<Integer> auxStack;

    SortStack() {
        auxStack = new MyStack<>();
    }

    public void sortStack(MyStack<Integer> stack) {
        while (!stack.isEmpty()) {
            int currentValue = stack.pop();
            // insert in auxStack
            pushElement(stack, currentValue);
        }

        // copy the values to initial stack
        copyStack(stack);
    }

    private void pushElement(MyStack<Integer> stack, int value) {
        while (!auxStack.isEmpty() && value < auxStack.peek()) {
            stack.push(auxStack.peek());
            auxStack.pop();
        }
        auxStack.push(value);


    }

    private void copyStack(MyStack<Integer> stack) {
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }

    public static void main(String[] args) {
        SortStack object = new SortStack();
        MyStack<Integer> stackToSort = new MyStack<>();
        stackToSort.push(2);
        stackToSort.push(3);
        stackToSort.push(3);
        stackToSort.push(4);
        stackToSort.push(7);
        stackToSort.push(1);
        stackToSort.print();
        object.sortStack(stackToSort);
        stackToSort.print();
    }
}
