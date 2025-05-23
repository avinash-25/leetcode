class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n - k + 1]; // subarray sums of length k

        // Step 1: Compute all window sums of size k
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            if (i >= k) curSum -= nums[i - k];
            if (i >= k - 1) sum[i - k + 1] = curSum;
        }

        // Step 2: Build left max array
        int[] left = new int[sum.length];
        int best = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > sum[best]) best = i;
            left[i] = best;
        }

        // Step 3: Build right max array
        int[] right = new int[sum.length];
        best = sum.length - 1;
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] >= sum[best]) best = i; // use >= to favor left side for lexicographical order
            right[i] = best;
        }

        // Step 4: Try all middle intervals
        int[] res = new int[3];
        int maxTotal = 0;
        for (int mid = k; mid < sum.length - k; mid++) {
            int l = left[mid - k], r = right[mid + k];
            int total = sum[l] + sum[mid] + sum[r];
            if (total > maxTotal) {
                maxTotal = total;
                res[0] = l;
                res[1] = mid;
                res[2] = r;
            }
        }

        return res;
    }
}
