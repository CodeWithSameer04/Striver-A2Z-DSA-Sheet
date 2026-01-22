/*
class ListNode {
    int data;
    ListNode prev, next;
    ListNode(int val) {
        this.data = val;
        this.prev = null;
        this.next = null;
    }
}
*/

class Solution {
    public ListNode reverseDLL(ListNode head) {
        // Empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode temp = null;

        // Traverse and swap prev & next for each node
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // Move to next node (which is previous before swap)
            curr = curr.prev;
        }

        // temp will be at the old head's prev
        return temp.prev;
    }
}

