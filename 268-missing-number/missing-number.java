import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len - 1];
        int min = nums[0];
        
        if (min != 0) {
            return 0;
        }

        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }

        return max + 1;
    }
}
