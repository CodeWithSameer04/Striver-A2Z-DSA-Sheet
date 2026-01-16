import java.util.ArrayList;
class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
        int left = 0, right = nums.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums.get(mid) > nums.get(right)) {
                left = mid + 1;
            } 
            else {
                right = mid;
            }
        }
        return left;
    }
}