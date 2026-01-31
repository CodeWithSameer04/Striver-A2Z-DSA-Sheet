class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int sum = k; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        return dp[k];
    }
}
