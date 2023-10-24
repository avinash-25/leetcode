class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }

            while (k < 0) {
                
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }

           
            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }
}
