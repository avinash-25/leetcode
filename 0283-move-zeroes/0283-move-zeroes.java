class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0; // Pointer for the position of the last non-zero element

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex] = nums[i];
                lastNonZeroIndex++;
            }
        }

        // Fill the remaining positions with zeros
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
