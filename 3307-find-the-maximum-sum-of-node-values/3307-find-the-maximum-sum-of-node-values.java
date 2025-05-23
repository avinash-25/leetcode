class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long totalSum = 0;
        long maxGain = Long.MIN_VALUE;
        int countPositiveGain = 0;
        long totalGain = 0;

        for (int num : nums) {
            int xorVal = num ^ k;
            int gain = xorVal - num;
            totalSum += num;

            if (gain > 0) {
                totalGain += gain;
                countPositiveGain++;
            }
            maxGain = Math.max(maxGain, gain);
        }

        if (countPositiveGain % 2 == 0) {
            return totalSum + totalGain;
        } else {
            // Remove the smallest positive gain (the one with least increase)
            long minExtraLoss = Long.MAX_VALUE;

            for (int num : nums) {
                int xorVal = num ^ k;
                int gain = xorVal - num;
                minExtraLoss = Math.min(minExtraLoss, Math.abs(gain));
            }

            return totalSum + totalGain - minExtraLoss;
        }
    }
}
