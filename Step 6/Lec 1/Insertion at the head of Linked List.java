/*
Definition of singly linked list:
class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
*/

class Solution {
    public ListNode insertAtHead(ListNode head, int X) {
        // Create a new node with value X
        ListNode newNode = new ListNode(X);
        
        // Point new node to the current head
        newNode.next = head;
        
        // New node becomes the head
        return newNode;
    }
}
