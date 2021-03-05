// linked list node
class Node<E> {
    E data;
    Node<E> next;

    Node() {
        next = null;
    }

    Node(E data) {
        this.data = data;
        next = null;
    }
}
