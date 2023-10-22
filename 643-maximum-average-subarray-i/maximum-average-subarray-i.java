class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return (double) nums[0];
        }
        
        int i = 0;
        int j = k;
        double sum = 0;

        for (int x = i; x < j; x++) {
            sum += nums[x];
        }

        double maxAvg = sum / k;

        while (j < len) {
            sum = sum - nums[i] + nums[j];
            i++;
            j++;
            double currentAvg = sum / k;
            
            maxAvg = Math.max(maxAvg, currentAvg);
        }

        return maxAvg;
    }
}
