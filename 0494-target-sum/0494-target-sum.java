class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i=0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((target + sum) % 2 != 0 || target > sum || target < -sum) {
            return 0;
        }

        int subsetSum = (target + sum) / 2;

        return countSubsets(nums, subsetSum);
    }

    private int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}
