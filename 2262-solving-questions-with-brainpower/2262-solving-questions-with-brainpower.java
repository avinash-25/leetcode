class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // DP array to store the max points at each index
        
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            
            // Solve the current question
            int nextIndex = i + brainpower + 1;
            long solve = points + (nextIndex < n ? dp[nextIndex] : 0);
            
            // Skip the current question
            long skip = dp[i + 1];
            
            // Take the maximum of solving or skipping
            dp[i] = Math.max(solve, skip);
        }
        
        return dp[0];
    }
}
