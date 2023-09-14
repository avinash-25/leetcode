class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int count = 1;
        int i=0,j=1;
        for (i=1;i<len;i++){
            if(nums[i] == nums[i-1])
               count++;
            else
               count = 1;
            if(count <=2){
               nums[j] = nums[i];
               j++;
            }
        }
      return j;
    }
}