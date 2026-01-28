/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node curr = head;

        // Step 1: Insert copied nodes
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return dummy.next;
    }
}
