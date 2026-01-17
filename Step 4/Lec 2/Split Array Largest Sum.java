class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int maxNum = 0;
        long sum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            sum += num;
        }

        long low = maxNum;
        long high = sum;
        long answer = sum;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                answer = mid;       // feasible, try smaller max sum
                high = mid - 1;
            } else {
                low = mid + 1;      // not feasible, increase max sum
            }
        }

        return (int) answer;
    }

    private boolean canSplit(int[] nums, int k, long maxAllowed) {
        int count = 1;
        long currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxAllowed) {
                count++;
                currentSum = num;
                if (count > k) return false;
            } else {
                currentSum += num;
            }
        }

        return true;
    }
}
