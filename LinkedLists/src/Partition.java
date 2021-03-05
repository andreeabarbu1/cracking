import java.util.Currency;

public class Partition {

    // partition a linked list around a value x, such that all nodes less
    // than x come before all nodes greater or equal to x
    public static MyLinkedList<Integer> partition(MyLinkedList<Integer> list, Integer x) {
        Node<Integer> currentNode = list.head;
        MyLinkedList<Integer> lessThanXNodes = new MyLinkedList<>();
        MyLinkedList<Integer> greaterOrEqualThanXNodes = new MyLinkedList<>();
        while (currentNode != null) {
            if (currentNode.data < x) {
                lessThanXNodes.insert(lessThanXNodes, currentNode.data);
            } else {
                greaterOrEqualThanXNodes.insert(greaterOrEqualThanXNodes, currentNode.data);
            }
            currentNode = currentNode.next;
        }

        // concat the linked lists
        lessThanXNodes.tail.next = greaterOrEqualThanXNodes.head;
        return lessThanXNodes;
    }

    // start a "new" list (using the existing nodes), using two nodes - head and tail
    public static Node<Integer> partition2(MyLinkedList<Integer> list, Integer x) {
        Node<Integer> head = list.head;
        Node<Integer> tail = list.head;
        Node<Integer> currentNode = list.head;
        while (currentNode != null) {
            Node<Integer> nextNode = currentNode.next;
            if (currentNode.data < x) {
                // insert node at head
                currentNode.next = head;
                head = currentNode;
            } else {
                // insert node at tail
                tail.next = currentNode;
                tail = currentNode;
            }
            currentNode = nextNode;
        }

        tail.next = null;

        return head;
    }

        public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(list, 6);
        list.insert(list, 3);
        list.insert(list, 7);
        list.insert(list, 9);
        list.insert(list, 2);
        list.insert(list, 3);
        list.insert(list, 1);

        list.printLst(list);
        System.out.println();
        MyLinkedList<Integer> modifiedList = partition(list, 5);
        modifiedList.printLst(modifiedList);
        System.out.println();
        ListMethods.printList(partition2(list, 5));
    }
}
