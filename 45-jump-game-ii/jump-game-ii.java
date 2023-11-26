class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        int i = 0, count = 0, n = nums.length - 2;
        int k1, k2, j = 1, keep;
        while(true){
            if(nums[i] == 0) return 0;
            count++;
            keep = k1 = i + nums[i];
            if(n < k1) return count;
            k2 = k1 + nums[k1];
            for(; j < keep; j++){
                if(k2 <= j + nums[j]){
                    k1 = j;
                    k2 = k1 + nums[k1];
                }
            }
            i = k1;
            j = keep;
        }
    }
}