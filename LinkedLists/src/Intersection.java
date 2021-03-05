public class Intersection {
    public static <E> Node<E> findIntersectingNode(MyLinkedList<E> l1, MyLinkedList<E> l2) {
        Node<E> node1 = l1.head;
        Node<E> node2 = l2.head;
        int length1 = l1.lengthOfTheList(l1);
        int length2 = l2.lengthOfTheList(l2);

        if (l1.tail != l2.tail) {
            return null;
        }

        // if the lists have different length
        if (length1 > length2) {
            node1 = goToTheSamePosition(node1, length1 - length2);
        } else if (length1 < length2) {
            node2 = goToTheSamePosition(node2, length2 - length1);
        }

        while (node1 != node2 && node1 != null && node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    public static <E> Node<E> goToTheSamePosition (Node<E> node, int position) {
        for (int i = 0; i < position && node != null; i++) {
            node = node.next;
        }

        return node;
    }


    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        MyLinkedList<Integer> list3 = new MyLinkedList<>();
        list1.insert(list1,1);
        list1.insert(list1,2);
        list1.insert(list1,3);
        list1.insert(list1,4);
        list2.insert(list2,5);
        list2.insert(list2,6);
        list3.insert(list3, 10);
        list3.insert(list3, 11);
        list3.insert(list3, 12);
        list1.tail.next = list3.head;
        list1.tail = list3.tail;
        list2.tail.next = list3.head;
        list2.tail = list3.tail;

        list1.printLst(list1);
        System.out.println();
        list2.printLst(list2);
        System.out.println();

        Node<Integer> node = findIntersectingNode(list1, list2);
        if (node == null) {
            System.out.println("The lists don't intersect.");
        } else {
            System.out.println("The intersecting node: " + node.data);
        }
    }
}
