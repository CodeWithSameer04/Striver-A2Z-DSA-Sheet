/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case
        if (head == null || head.next == null) return head;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split list into two halves
        prev.next = null;  // break the list

        // Step 3: Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Step 4: Merge sorted halves
        return merge(left, right);
    }

    // Merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Attach remaining nodes
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
    }
}
