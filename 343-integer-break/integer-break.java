class Solution {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1; // Special cases for n = 1 and n = 2
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            // Initialize dp[i] with a minimum value
            dp[i] = Integer.MIN_VALUE;

            // Try breaking i into two parts j and (i-j)
            for (int j = 1; j < i; j++) {
                // Calculate the product if we break i into j and (i-j)
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }

        return dp[n];
    }
}
