class Solution {
    public int findNumbers(int[] nums) {
        int len = nums.length;
        int count=0,num=0;
        for(int i=0;i<len;i++){
            num = (int)(Math.log10(nums[i]))+1;
            if(num %2 == 0)
               count++;
        }
        return count;
    }
}