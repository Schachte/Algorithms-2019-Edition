package linkedlists;

public class DeleteKthNode {
    private class Node {
        public int val;
        public Node next;

        public Node(int _val, Node _next) {
            this.val = _val;
            this.next = _next;
        }
    }
    public static void main(String[] args) {
        DeleteKthNode delNode = new DeleteKthNode();
        Node head = delNode.generateNewLL();
        head = delNode.deleteKthFromEnd(head, 2);

    }

    public Node deleteKthFromEnd(Node head, int num) {
        int count = 0;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        int curr = 0;
        if (count - curr == num) return head.next;

        temp = head;
        while (curr != count - num) {
            curr++;
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    public Node generateNewLL() {
        return new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
    }
}
