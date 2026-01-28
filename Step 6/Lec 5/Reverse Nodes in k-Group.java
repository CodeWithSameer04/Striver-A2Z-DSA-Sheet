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
    public ListNode reverseKGroup(ListNode head, int k) {

        // Step 1: Check if there are at least k nodes
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return head; // less than k nodes
            temp = temp.next;
        }

        // Step 2: Reverse k nodes
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;

        while (count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Step 3: Recursively process remaining list
        head.next = reverseKGroup(curr, k);

        return prev; // new head
    }
}
