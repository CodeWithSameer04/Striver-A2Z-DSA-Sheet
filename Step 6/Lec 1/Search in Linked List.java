/* Defination of ListNoode
class ListNode {
    int val;
    ListNode next;

    ListNode(int value) {
        this.val = value;
        this.next = null;
    }
}
*/


class Solution {
    public boolean searchKey(ListNode head, int key) {
        ListNode current = head;
        
        while (current != null) {
            if (current.val == key) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
}
