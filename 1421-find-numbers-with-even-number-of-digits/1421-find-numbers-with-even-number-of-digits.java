class Solution {
    public int findNumbers(int[] nums) {
       int len = nums.length;
       int count = 0;

       for(int num : nums){
        int digit = String.valueOf(num).length();
        if(digit % 2 == 0)
           count++;
       } 

       return count;
    }
}