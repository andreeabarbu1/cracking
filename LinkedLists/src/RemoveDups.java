import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;

public class RemoveDups extends ListMethods{

    // O(n)
    public static void removeDups (MyLinkedList<Character> list) {
        HashSet<Character> characters = new HashSet<>();
        Node<Character> currentNode = list.head;
        Node<Character> prevNode = new Node<>();

        while (currentNode != null) {
            if(!characters.contains(currentNode.data)) {
                characters.add(currentNode.data);
                prevNode = currentNode;
            } else {
                // the last node
                if (currentNode.next == null) {
                    prevNode.next = null;
                }
                prevNode.next = currentNode.next;
            }
            currentNode = currentNode.next;
        }
    }

    // no buffer allowed
    // O(n^2)
    public static void removeDupsNoBuffer(MyLinkedList<Character> list) {
        Node<Character> currentNode = list.head;

        while (currentNode != null) {
            // runner
            Node<Character> runnerNode = currentNode;
            while (runnerNode.next != null) {
                if (runnerNode.next.data == currentNode.data) {
                    runnerNode.next = runnerNode.next.next;
                } else {
                    runnerNode = runnerNode.next;
                }
            }

            // next node
            currentNode = currentNode.next;
        }
    }


    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.insert(list, 'F');
        list.insert(list, 'O');
        list.insert(list, 'L');
        list.insert(list, 'L');
        list.insert(list, 'L');
        list.insert(list, 'L');
        list.insert(list, 'L');
        list.insert(list, 'L');
        list.insert(list, 'O');
        list.insert(list, 'W');
        list.insert(list, 'U');
        list.insert(list, 'P');
        list.insert(list, 'P');
        list.insert(list, 'P');

        list.printLst(list);
        System.out.println();
        //removeDups(list);
        removeDupsNoBuffer(list);
        list.printLst(list);
    }
}
