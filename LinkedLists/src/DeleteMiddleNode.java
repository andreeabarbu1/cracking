public class DeleteMiddleNode {
    // delete a node in the middle of a singly linked list,
    // given only access to that node
    public static <E> void deleteAMiddleNode(Node<E> middleNode) {
        middleNode.data = middleNode.next.data;
        middleNode.next = middleNode.next.next;
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

        list.printLst(list);
        Node<Integer> middleNode = list.head.next.next.next.next;
        System.out.println("Delete node: " + middleNode.data);
        deleteAMiddleNode(middleNode);
        list.printLst(list);

    }
}
