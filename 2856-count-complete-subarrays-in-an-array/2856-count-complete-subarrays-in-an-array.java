import java.util.*;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> fullSet = new HashSet<>();
        
        // Step 1: Count total distinct elements in the full array
        for (int num : nums) {
            fullSet.add(num);
        }
        int totalDistinct = fullSet.size();
        
        int count = 0;

        // Step 2: Try all subarrays
        for (int i = 0; i < n; i++) {
            Set<Integer> subSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                subSet.add(nums[j]);
                if (subSet.size() == totalDistinct) {
                    count++;
                }
            }
        }

        return count;
    }
}
