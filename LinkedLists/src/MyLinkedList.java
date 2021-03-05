/*

 */
public class MyLinkedList<E> implements MyList<E>{

    Node<E> head; // head of list
    Node<E> tail; // tail of list

    // method to insert a new node
    @Override
    public <T extends MyList<E>> void insert(T list, E data) {
        MyLinkedList myList = (MyLinkedList) list;

        // create a new node with given data, add it to the end
        Node<E> newNode = new Node<>(data);
        newNode.next = null;

        if (myList.head == null) {
            myList.head = newNode;
            myList.tail = newNode;
        } else {
            Node<E> last = myList.head;
            while (last.next != null) {
                last = last.next;
            }

            // insert the new_node at last node
            last.next = newNode;
            tail = newNode;
        }

        //return (T)myList;
    }

    // return the size of the list
    @Override
    public <T extends MyList<E>> int lengthOfTheList(T list) {
        MyLinkedList myList = (MyLinkedList) list;
        Node<E> currentNode = myList.head;
        int size = 0;

        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    // method to insert a node at the beginning
    @Override
    public <T extends MyList<E>> void insertAtBegin(T list, E data) {
        MyLinkedList myList = (MyLinkedList) list;

        // create a new node with given data, add it to the end
        Node<E> newNode = new Node<>(data);
        newNode.next = null;

        if (myList.head == null) {
            myList.head = newNode;
            myList.tail = newNode;
        } else {
            newNode.next = myList.head;
            myList.head = newNode;
        }
        //return (T)myList;
    }

    // method to delete a node in the linked list by key
    @Override
    public <T extends MyList<E>> void deleteByKey(T list, E key) {
        MyLinkedList mylist = (MyLinkedList)list;
        Node<E> currentNode = mylist.head;

        // the head holds the key to be deleted
        if (currentNode != null && currentNode.data == key) {
            mylist.head = currentNode.next;

            System.out.println("The key was found: " + key);

            return;
        }

        Node<E> prevNode = null;
        prevNode = currentNode;

        // the key isn't the head
        while (currentNode != null) {
            if (currentNode.data == key && currentNode.next != null) {
                prevNode.next = currentNode.next;
                currentNode = null;

                System.out.println("The key was found: " + key);
                return;
            } else if (currentNode.data == key && currentNode.next == null) {
                prevNode.next = null;
                System.out.println("The key was found: " + key);
                return;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        // the key wasn't found
        if (currentNode == null) {
            System.out.println("The key wasn't found");
        }

    }

    @Override
    public void printLst(MyList list) {
        MyLinkedList myList = (MyLinkedList) list;
        Node<E> currentNode = myList.head;

        System.out.println("LinkedList: ");

        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedlist = new MyLinkedList();

        linkedlist.insert(linkedlist, 1);
        linkedlist.insert(linkedlist, 2);
        linkedlist.insert(linkedlist, 3);

        linkedlist.printLst(linkedlist);
        System.out.println();

        linkedlist.deleteByKey(linkedlist, 3);
        linkedlist.deleteByKey(linkedlist, 1);
        linkedlist.printLst(linkedlist);
    }
}

