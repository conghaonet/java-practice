package algorithm;

/**
 * 单链表反转
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.value = 1;
        Node node2 = new Node();
        node2.value = 2;
        Node node3 = new Node();
        node3.value = 3;
        Node node4 = new Node();
        node4.value = 4;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node newLinkedList = reverse(node1);

        System.out.print(newLinkedList);
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHeader = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHeader;
    }

    static class Node {
        int value;
        Node next;
    }
}
