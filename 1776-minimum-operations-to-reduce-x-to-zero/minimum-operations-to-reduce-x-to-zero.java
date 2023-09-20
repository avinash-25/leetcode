class Solution {
    public int minOperations(int[] nums, int x) {
        int targetSum = Arrays.stream(nums).sum() - x;
        if (targetSum < 0) {
            return -1; // It's not possible to achieve the target sum
        }

        int n = nums.length;
        int left = 0; // Left pointer of the sliding window
        int currentSum = 0; // Current sum of elements in the window
        int minOperations = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            // Shrink the window from the left as long as the currentSum is greater than targetSum
            while (currentSum > targetSum) {
                currentSum -= nums[left];
                left++;
            }

            // If the currentSum equals the targetSum, update minOperations
            if (currentSum == targetSum) {
                int operations = n - (right - left + 1); // Calculate the number of operations
                minOperations = Math.min(minOperations, operations);
            }
        }

        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }
}
