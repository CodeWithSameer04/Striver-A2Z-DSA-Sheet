/*
// Definition for a Node.
class ListNode {
    public int data;
    public ListNode prev;
    public ListNode next;
    public ListNode();
    public ListNode(int data);
    public ListNode(int data, ListNode prev, ListNode next);
};
*/

class Solution {
    public ListNode deleteHead(ListNode head) {
        // If list is empty or has only one node
        if (head == null || head.next == null) {
            return null;
        }

        // Move head to the next node
        head = head.next;

        // Remove backward link
        head.prev = null;

        return head;
    }
}

