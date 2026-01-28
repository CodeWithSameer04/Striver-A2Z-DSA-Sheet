/*Definition for singly Linked List
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
*/
class Solution {

    public ListNode flattenLinkedList(ListNode head) {

        // Base case
        if (head == null || head.next == null)
            return head;

        // Flatten the rest of the list
        head.next = flattenLinkedList(head.next);

        // Merge current list with flattened next list
        head = merge(head, head.next);

        return head;
    }

    private ListNode merge(ListNode a, ListNode b) {

        if (a == null) return b;
        if (b == null) return a;

        ListNode result;

        if (a.val < b.val) {
            result = a;
            result.child = merge(a.child, b);
        } else {
            result = b;
            result.child = merge(a, b.child);
        }

        result.next = null; // remove next pointer
        return result;
    }
}
