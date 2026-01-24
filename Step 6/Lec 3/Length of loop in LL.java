/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public int findLengthOfLoop(ListNode head) {
        if (head == null || head.next == null) return 0;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Count loop length
                int length = 1;
                fast = fast.next;
                while (fast != slow) {
                    fast = fast.next;
                    length++;
                }
                return length;
            }
        }

        // No loop
        return 0;
    }
}
