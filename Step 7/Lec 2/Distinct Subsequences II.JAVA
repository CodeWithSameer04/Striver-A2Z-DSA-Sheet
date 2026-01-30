class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();

        long[] dp = new long[n + 1];
        dp[0] = 1; // empty subsequence

        // stores last index (1-based) where char appeared
        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int idx = c - 'a';

            dp[i] = (dp[i - 1] * 2) % MOD;

            if (last[idx] != -1) {
                dp[i] = (dp[i] - dp[last[idx] - 1] + MOD) % MOD;
            }

            last[idx] = i;
        }

        // remove empty subsequence
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}
