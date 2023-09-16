class Solution {
    public int peakIndexInMountainArray(int[] nums) {
       int len = nums.length;
        int[] temp = new int[len];
        for(int i=0;i<len;i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int n = temp[len-1];
        for(int i=0;i<len;i++){
            if(nums[i] == n)
              return i;
        }
        return 0; 
    }
}