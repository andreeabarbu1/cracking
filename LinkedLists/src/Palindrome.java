import java.util.Stack;

public class Palindrome {

    // use fast runner/slow runner technique and a stack
    public static <E> boolean isPalindrome(MyLinkedList<E> list) {
        Node<E> fast = list.head;
        Node<E> slow = list.head;
        Stack<E> stack = new Stack<>();

        // when the fast runner reaches the end of the list, the slow runner
        // will be in the middle
        while (fast != null && fast.next != null) {
            // push elements from first half of linked list
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd length, skip the middle
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.data != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> mylist = new MyLinkedList<>();
        mylist.insert(mylist, 1);
        mylist.insert(mylist, 2);
        mylist.insert(mylist, 3);
        mylist.insert(mylist, 4);
        mylist.insert(mylist, 3);
        mylist.insert(mylist, 2);
        mylist.insert(mylist, 1);
        //mylist.insert(mylist, 1);

        mylist.printLst(mylist);
        System.out.println();
        System.out.println(isPalindrome(mylist));

    }
}
