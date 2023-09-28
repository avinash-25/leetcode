class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0; // Pointer for even numbers
        int right = nums.length - 1; // Pointer for odd numbers
        
        while (left < right) {
            // Move the left pointer to the right until an odd number is found
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            
            // Move the right pointer to the left until an even number is found
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            
            // Swap the even and odd numbers
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            
            // Move the pointers to continue the process
            left++;
            right--;
        }
        
        return nums;
    }
}
