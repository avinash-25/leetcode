class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;
        
        int lastMin = -1;    // Last position where nums[i] == minK
        int lastMax = -1;    // Last position where nums[i] == maxK
        int badIndex = -1;   // Last index where element was out of [minK, maxK] range
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                badIndex = i;
            }
            if (nums[i] == minK) {
                lastMin = i;
            }
            if (nums[i] == maxK) {
                lastMax = i;
            }
            // Only consider valid subarrays
            int validStart = Math.min(lastMin, lastMax);
            if (validStart > badIndex) {
                count += validStart - badIndex;
            }
        }
        
        return count;
    }
}
