class Solution {
    public int numWays(int steps, int arrLen) {
        int MOD = 1000000007;
        int maxPos = Math.min(steps / 2, arrLen - 1); 
        long[][] dp = new long[steps + 1][maxPos + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxPos; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                }
                if (j < maxPos) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        return (int) dp[steps][0];
    }
}
