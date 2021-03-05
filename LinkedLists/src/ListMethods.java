import java.util.LinkedList;

public class ListMethods {
    public static <T> void printList(LinkedList<T> list) {
        System.out.println("Linked List: ");
        for (T elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static <T> void printList(Node<T> node) {
        Node<T> auxNode = node;
        System.out.println("Linked List: ");
        while (auxNode != null) {
            System.out.print(auxNode.data + " ");
            auxNode = auxNode.next;
        }
        System.out.println();
    }
}
