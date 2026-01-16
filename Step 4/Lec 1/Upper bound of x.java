class Solution {
    public int upperBound(int[] nums, int x) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > x) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
