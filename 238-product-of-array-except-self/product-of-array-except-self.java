class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // Calculate prefix products
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        // Calculate suffix products and multiply them with prefix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = prefix[i] * suffix;
            suffix *= nums[i];
        }
        
        return ans;
    }
}
