class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        while (min <= max) {
            int guess = min + (max - min) / 2;

            if (nums[guess] == target) {
                return guess;
            } else if (nums[guess] < target) {
                min = guess + 1;
            } else {
                max = guess - 1;
            }
        }

        return -1;
    }
}
