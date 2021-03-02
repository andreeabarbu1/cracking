import java.util.LinkedList;

public class ListMethods {
    public static <T> void printList(LinkedList<T> list) {
        System.out.println("Linked List: ");
        for (T elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
