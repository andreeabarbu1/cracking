import java.util.LinkedList;

public class SumLists {
    // add the two numbers (represented by two linked list)
    // and return the sum as a linked list (they are stored in reverse order)
    public static MyLinkedList<Integer> sumListsReverseNumber(MyLinkedList<Integer> nr1, MyLinkedList<Integer> nr2) {
        MyLinkedList<Integer> sum = new MyLinkedList<>();
        Node<Integer> node1 = nr1.head;
        Node<Integer> node2 = nr2.head;

        int carry = 0;
        while (node1 != null && node2 != null) {
            int digitsSum = node1.data + node2.data + carry;
            if (digitsSum > 10) {
                carry = 1;
            }
            digitsSum = digitsSum % 10;

            sum.insert(sum, digitsSum);

            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null) {
            sum.insert(sum, carry + node1.data);
            carry = 0;
            node1 = node1.next;
        }

        while (node2 != null) {
            sum.insert(sum, carry + node2.data);
            carry = 0;
            node2 = node1.next;
        }
        return sum;
    }

    class PartialSum {
        public MyLinkedList<Integer> sum = new MyLinkedList<>();
        public int carry = 0;
    }

    // add the two numbers (represented by two linked list)
    // and return the sum as a linked list
    public MyLinkedList<Integer> sumLists(MyLinkedList<Integer> nr1, MyLinkedList<Integer> nr2) {
        // one list can be shorter than the other
        int length1 = nr1.lengthOfTheList(nr1);
        int length2 = nr2.lengthOfTheList(nr2);
        // pad the shorter list with zeros
        if (length1 > length2) {
            paddingZero(nr2, length1 - length2);
        } else if (length1 < length2) {
            paddingZero(nr1, length2 - length1);
        }

        //nr1.printLst(nr1);
        //nr2.printLst(nr2);

        // add lists
        PartialSum sum = addLists(nr1.head, nr2.head);

        // if this is a carry value left over, insert at the beginning
        if (sum.carry != 0) {
            MyLinkedList<Integer> result = sum.sum;
            result.insertAtBegin(result, sum.carry);
            return result;
        } else {
            return sum.sum;
        }
    }

    private PartialSum addLists(Node<Integer> nr1, Node<Integer> nr2) {
        if (nr1 == null || nr2 == null) {
            return new PartialSum();
        }

        // add smaller digits recursively
        PartialSum sum;
        sum = addLists(nr1.next, nr2.next);

        // add carry to current data
        int value = sum.carry + nr1.data + nr2.data;

        // insert sum of current digits
        sum.sum.insertAtBegin(sum.sum, value % 10);

        sum.carry = value / 10;
        return sum;
    }

    private void paddingZero(MyLinkedList<Integer> number, int difference) {
        for (int i = 0; i < difference; i++) {
            number.insertAtBegin(number, 0);
        }
    }

    public static void main(String[] args) {
/*
        // part one
        // the digits are stored in reverse order
        MyLinkedList<Integer> number1 = new MyLinkedList<>();
        number1.insert(number1, 7);
        number1.insert(number1, 1);
        number1.insert(number1, 6);
        MyLinkedList<Integer> number2 = new MyLinkedList<>();
        number2.insert(number2, 5);
        number2.insert(number2, 9);
        number2.insert(number2, 2);

        number1.printLst(number1);
        System.out.println();
        number2.printLst(number2);
        System.out.println();

        MyLinkedList<Integer> sum = new MyLinkedList<>();
        sum = sumListsReverseNumber(number1, number2);
        sum.printLst(sum);
*/
        // part two
        // the digits are stored in normal order
        MyLinkedList<Integer> number1 = new MyLinkedList<>();
        number1.insert(number1, 6);
        number1.insert(number1, 1);
        number1.insert(number1, 7);
        MyLinkedList<Integer> number2 = new MyLinkedList<>();
        //number2.insert(number2, 1);
        number2.insert(number2, 3);
        number2.insert(number2, 9);
        number2.insert(number2, 5);

        number1.printLst(number1);
        System.out.println();
        number2.printLst(number2);
        System.out.println();

        SumLists obj = new SumLists();
        MyLinkedList<Integer> sum = new MyLinkedList<>();
        sum = obj.sumLists(number1, number2);
        sum.printLst(sum);
    }
}
