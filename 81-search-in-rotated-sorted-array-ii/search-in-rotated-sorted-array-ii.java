class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        for(int i=0;i<len;i++){
          if(target == nums[i])
             return true;
        }
        return false;
    }
}