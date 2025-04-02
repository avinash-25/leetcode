class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxValue = 0;
        int maxPrefix = nums[0]; 
        int maxDiff = Integer.MIN_VALUE; 
        
        for (int j = 1; j < n - 1; j++) {
            maxDiff = Math.max(maxDiff, maxPrefix - nums[j]);
            maxValue = Math.max(maxValue, (long) maxDiff * nums[j + 1]);
            maxPrefix = Math.max(maxPrefix, nums[j]);
        }
        
        return maxValue;
    }
}
