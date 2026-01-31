class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1; // empty subsequence
        
        for (int num : nums) {
            for (int sum = k; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }
        
        // exclude empty subsequence if k == 0
        return k == 0 ? dp[k] - 1 : dp[k];
    }
}
