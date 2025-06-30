import java.util.Arrays;

class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);  // Step 1: Sort the array
        int left = 0, result = 0;

        // Step 2: Use sliding window (two pointers)
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;  // shrink the window from left if difference is > 1
            }

            if (nums[right] - nums[left] == 1) {
                result = Math.max(result, right - left + 1);  // update result
            }
        }

        return result;
    }
}
