class Solution {
    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return true; // An array with 0 or 1 element is considered monotonic.
        }

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            } else if (nums[i] < nums[i - 1]) {
                increasing = false;
            }

            // If both increasing and decreasing flags become false, the array is neither
            // increasing nor decreasing.
            if (!increasing && !decreasing) {
                return false;
            }
        }

        return true;
    }
}
