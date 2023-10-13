class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        // Initialize the first two steps.
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Calculate the minimum cost for each step.
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // The minimum cost to reach the top can be either the last step or the second to last step.
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
