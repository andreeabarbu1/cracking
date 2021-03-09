import java.lang.Integer;

/* a stack which has a special method min() - it returns the
    minimum element in O(1) time
 */
public class StackMin extends MyStack<Integer>{
    MyStack<Integer> minStack;

    StackMin() {
        minStack = new MyStack<>();
    }

    @Override
    public void push(Integer data) {
        super.push(data);
        if (data <= min()) {
            minStack.push(data);
        }
    }

    @Override
    public Integer pop() {
        int value = super.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return java.lang.Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }
}
