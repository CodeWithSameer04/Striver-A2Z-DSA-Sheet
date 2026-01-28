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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        // Step 1: Find length and last node
        ListNode curr = head;
        int len = 1;

        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        // Step 2: Normalize k
        k = k % len;
        if (k == 0) return head;

        // Step 3: Make circular
        curr.next = head;

        // Step 4: Find new tail (len - k steps)
        int stepsToNewTail = len - k;
        ListNode newTail = head;

        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
