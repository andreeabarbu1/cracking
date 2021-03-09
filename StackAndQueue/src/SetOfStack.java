/*
    A set of stack, composed of several stacks and should create
    a new stack once the previous one exceeds capacity
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStack<E> {
    private ArrayList<MyStack<E>> stacks;
    private int threshold;

    SetOfStack(int threshold) {
        stacks = new ArrayList<>();
        this.threshold = threshold;
    }

    public void push(E data) {
        if (stacks.size() == 0) {
            addNewStack(stacks, data);
            return;
        }
        MyStack<E> lastStack = stacks.get(stacks.size() - 1);
        if (lastStack.getLength() >= threshold) {
            addNewStack(stacks, data);
        } else {
            stacks.get(stacks.size() - 1).push(data);
        }

    }

    private void addNewStack(ArrayList<MyStack<E>> stacks, E data) {
        MyStack<E> newStack = new MyStack<>();
        newStack.push(data);
        stacks.add(newStack);
    }

    public E pop() {
        MyStack<E> lastStack = stacks.get(stacks.size() - 1);
        if (stacks.size() == 0) {
            throw new EmptyStackException();
        }
        if (lastStack.getLength() == 1) {
            E value = lastStack.pop();
            stacks.remove(stacks.size() - 1);
            return value;
        }
        return lastStack.pop();
    }

    public void printStacks() {
        for (MyStack<E> s : stacks) {
            s.print();
        }
    }

    public static void main(String[] args) {
        SetOfStack<Integer> stacks = new SetOfStack<>(3);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        //stacks.printStacks();
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());

    }
}
