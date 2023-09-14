class Solution {
    public boolean containsDuplicate(int[] nums) {
       int len = nums.length;
       Arrays.sort(nums);
       if(len == 2 && (nums[0] == nums[1]))
             return true;
       for(int i=0;i<len-1;i++){
           if(nums[i] == nums[i+1])
             return true;
       }
       return false;
    }   
}