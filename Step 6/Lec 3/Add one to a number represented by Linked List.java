/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public ListNode addOne(ListNode head) {
        // Step 1: Reverse the linked list
        head = reverse(head);

        ListNode curr = head;
        int carry = 1;

        // Step 2: Add one
        while (curr != null && carry > 0) {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;

            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                carry = 0;
                break;
            }
            curr = curr.next;
        }

        // Step 3: Reverse back
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
