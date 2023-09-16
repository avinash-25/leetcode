class Solution {
    public int peakIndexInMountainArray(int[] nums) {
       int len = nums.length;
       int max = nums[0],i=0,temp=0;
       for(i=1;i<len;i++){
           if(max < nums[i]){
              max = nums[i];
              temp = i;
            }
       }
       return temp; 
    }
}