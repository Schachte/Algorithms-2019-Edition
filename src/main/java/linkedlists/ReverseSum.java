package linkedlists;

/**
 * The goal of this algorithm is to sum two linkedlists together.
 * The linkedlists are represented in reverse order.
 */
public class ReverseSum {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[]args) {
        ListNode n1 = new ListNode(2);
        ListNode n1_2 = new ListNode(4);
        ListNode n1_3 = new ListNode(3);

        n1.next = n1_2;
        n1_2.next = n1_3;

        ListNode n2 = new ListNode(5);
        ListNode n2_2 = new ListNode(6);
        ListNode n2_3 = new ListNode(4);

        n2.next = n2_2;
        n2_2.next = n2_3;

        ListNode sum = add(n1, n2);
    }

    public static ListNode add(ListNode n1, ListNode n2) {
        ListNode head = null;
        ListNode temp = null;

        // bit that represents carryover or not
        int carryOver = 0;

        // while the two lists are matched up 1:1, we can continue adding them
        while (n1.next != null && n2.next != null) {
            int currentValue = ((n1.val + n2.val)) + carryOver;

            // Carryover is present
            if (currentValue >= 10) {
                carryOver = 1;
                currentValue = (n1.val + n2.val) % 10;
            }

            if (head == null) {
                head = new ListNode(currentValue);
                temp = head;
            } else {
                temp.next = new ListNode(currentValue);
                temp = temp.next;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        if (n1 != null && n2 != null) {
            temp.next = new ListNode(n1.val + n2.val + carryOver);
            temp = temp.next;
        }

        if (n1.next != null) {
            temp.next = new ListNode(n1.val);
        }

        while (n2.next != null) {
            temp.next = new ListNode(n2.val);
        }

        return head;
    }

    public ListNode constructIntegerList(String integer) {
       return null;
    }
}
