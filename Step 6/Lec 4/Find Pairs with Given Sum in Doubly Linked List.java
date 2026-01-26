/*
class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
*/

class Solution {
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (head == null) return result;

        // Find tail of the doubly linked list
        ListNode left = head;
        ListNode right = head;
        while (right.next != null) {
            right = right.next;
        }

        // Two-pointer approach
        while (left != null && right != null && left != right && left.prev != right) {
            int sum = left.val + right.val;

            if (sum == target) {
                result.add(Arrays.asList(left.val, right.val));
                left = left.next;
                right = right.prev;
            } 
            else if (sum < target) {
                left = left.next;
            } 
            else {
                right = right.prev;
            }
        }
        return result;
    }
}
