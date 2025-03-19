class Solution {
    public int minOperations(int[] nums) {
        int len = nums.length;
        int operations = 0;

        for (int i = 0; i <= len - 3; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                operations++;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
               return -1;
        }

        return operations;
    }
}
