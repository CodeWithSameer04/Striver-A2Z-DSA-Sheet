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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode zeroHead = null, zeroTail = null;
        ListNode oneHead = null, oneTail = null;
        ListNode twoHead = null, twoTail = null;

        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = null; // detach

            if (curr.data == 0) {
                if (zeroHead == null) zeroHead = zeroTail = curr;
                else {
                    zeroTail.next = curr;
                    zeroTail = curr;
                }
            } 
            else if (curr.data == 1) {
                if (oneHead == null) oneHead = oneTail = curr;
                else {
                    oneTail.next = curr;
                    oneTail = curr;
                }
            } 
            else { // curr.data == 2
                if (twoHead == null) twoHead = twoTail = curr;
                else {
                    twoTail.next = curr;
                    twoTail = curr;
                }
            }

            curr = next;
        }

        // Connect 0 → 1 → 2
        if (zeroTail != null)
            zeroTail.next = (oneHead != null) ? oneHead : twoHead;
        if (oneTail != null)
            oneTail.next = twoHead;

        return (zeroHead != null) ? zeroHead :
               (oneHead != null) ? oneHead : twoHead;
    }
}
