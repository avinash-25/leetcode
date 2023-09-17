class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        
        // Create a temporary array to store the rotated values
        int[] temp = new int[k];
        
        // Copy the last 'k' elements into the temp array
        System.arraycopy(nums, len - k, temp, 0, k);
        
        // Shift the remaining elements to the right to make space for rotated elements
        System.arraycopy(nums, 0, nums, k, len - k);
        
        // Copy the rotated elements from temp back to the beginning of nums
        System.arraycopy(temp, 0, nums, 0, k);
    }
}
