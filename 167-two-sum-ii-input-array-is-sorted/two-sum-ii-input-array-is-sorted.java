class Solution {
    public int[] twoSum(int[] nums, int t) {
         /*for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] == t - nums[j]){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return null;*/
        int l = 0;
        int h = nums.length-1;
        while(nums[l] + nums[h] != t){
            if(nums[l] + nums[h] < t){
                l++;
            }
            else{
                h--;
            }
        }
        return new int[] {l+1, h+1};
    }
}