class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Create a dp array to store the minimum cost for each day
        int[] dp = new int[366]; // Days range from 1 to 365
        boolean[] travelDays = new boolean[366];

        // Mark the days when travel is planned
        for (int day : days) {
            travelDays[day] = true;
        }

        // Iterate through each day of the year
        for (int day = 1; day <= 365; day++) {
            if (!travelDays[day]) {
                dp[day] = dp[day - 1]; // No travel on this day, cost remains the same
                continue;
            }

            // Calculate the cost for each type of ticket
            int cost1 = dp[Math.max(0, day - 1)] + costs[0]; // 1-day pass
            int cost7 = dp[Math.max(0, day - 7)] + costs[1]; // 7-day pass
            int cost30 = dp[Math.max(0, day - 30)] + costs[2]; // 30-day pass

            // Take the minimum cost
            dp[day] = Math.min(cost1, Math.min(cost7, cost30));
        }

        // The answer is the minimum cost to travel on the last day in the array
        return dp[365];
    }
}
