// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//        int len = nums.length;
//        Arrays.sort(nums);
//        for(int i=0;i<len-1;i++){
//            if(nums[i] == nums[i+1])
//              return true;
//        }
//        return false;
//     }   
// }

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
