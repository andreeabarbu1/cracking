public class KthToLast {

    public static <E> Node<E> kthToLast(MyLinkedList<E> list, int k) {
        if (k < 0) {
            return null;
        }

        int currnentIndex = 0;
        Node<E> firstPointer = list.head, secondPointer = list.head;

        while (currnentIndex != k && firstPointer.next != null) {
            firstPointer = firstPointer.next;
            currnentIndex++;
        }

        // out of bounds
        if (firstPointer.next == null && k > currnentIndex) {
            return null;
        }

        while (firstPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return secondPointer;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(list, 1);
        list.insert(list, 2);
        list.insert(list, 3);
        list.insert(list, 4);
        list.insert(list, 5);
        list.insert(list, 6);
        list.insert(list, 7);

        Node<Integer> kthNode = kthToLast(list, 0); // from 0
        if (kthNode == null) {
            System.out.println("Out of bounds");
        } else {
            System.out.println("K-th node to last: " + kthNode.data);
        }

        list.printLst(list);
    }
}
