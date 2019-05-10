package linkedlists;

public class SinglyReverse {
    private class Node {
        Node next;
        int value;
        public Node(int value) { this.value = value; }
    }

    public static void main(String[] args) {

    }

    public Node reverse(Node head) {
        Node tail = null;
        Node temp = head;

        while (temp.next != null) {
            temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        head.next = tail;

        return head;
    }
}
