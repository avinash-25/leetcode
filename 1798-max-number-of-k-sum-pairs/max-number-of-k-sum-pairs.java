import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        int maxOps = 0;

        for (int num : nums) {
            int complement = k - num;
            if (numCounts.containsKey(complement) && numCounts.get(complement) > 0) {
                maxOps++;
                numCounts.put(complement, numCounts.get(complement) - 1);
            } else {
                numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
            }
        }

        return maxOps;
    }
}
