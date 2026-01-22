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
    public ListNode insertBeforeHead(ListNode head, int data) {
        // Create new node
        ListNode newNode = new ListNode(data);

        // If list is empty
        if (head == null) {
            return newNode;
        }

        // Link new node before current head
        newNode.next = head;
        head.prev = newNode;

        // New node becomes the head
        return newNode;
    }
}
