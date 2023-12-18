class Solution {
    public int maxProductDifference(int[] nums) {
       Arrays.sort(nums);
       int len = nums.length;
       return ((nums[len-2] * nums[len-1]) - (nums[0] * nums[1])); 
    }
}