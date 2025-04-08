import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        int len = nums.length;

        while (true) {
            Set<Integer> set = new HashSet<>();
            boolean allUnique = true;

            for (int i = operations * 3; i < len; i++) {
                if (!set.add(nums[i])) {
                    allUnique = false;
                    break;
                }
            }

            if (allUnique)
             return operations;

            
            operations++;

            
            if (operations * 3 >= len)
             return operations;
        }
    }
}
