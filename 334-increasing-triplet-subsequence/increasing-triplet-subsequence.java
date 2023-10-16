// class Solution {
//     public boolean increasingTriplet(int[] nums) {
        
//        for(int i=0;i<nums.length-2;i++){
//            if(nums[i] < nums[i+1] && nums[i+1] < nums[i+2])
//               return true;      
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {
//             map.put(i, nums[i]);
//         }

//     }
// }

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // Update the first element.
            } else if (num <= second) {
                second = num; // Update the second element.
            } else {
                return true; // We found a third element that's greater than the first two.
            }
        }

        return false; // No increasing triplet found.
    }
}