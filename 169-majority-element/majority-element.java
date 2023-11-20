import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int max = 0; 
        int temp = 0;
        int count = 1; 

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    temp = nums[i];
                    count = 1;
                }
            }
        }
        if (count > max) {
            temp = nums[len - 1];
        }

        return temp;
    }
}