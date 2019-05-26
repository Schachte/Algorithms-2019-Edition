package linkedlists;

public class SinglyReverseRecursive {
    private class Node {
        public int val;
        public Node next;

        public Node(int _val, Node _next) {
            this.val = _val;
            this.next = _next;
        }
    }

    public static void main(String[] args) {
        SinglyReverseRecursive list = new SinglyReverseRecursive();
        Node head = list.generateNewLL();
        Node newHead = list.reverseRecursive(head);
    }

    private Node reverseRecursive(Node node) {
        if (node.next == null) return node;
        Node curr = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return curr;
    }


    public Node generateNewLL() {
        return new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
    }
}
