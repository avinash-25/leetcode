class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        // Build the difference array from queries
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l] += 1;
            if (r + 1 < n) {
                diff[r + 1] -= 1;
            }
        }

        // Build the coverage array using prefix sum
        int[] coverage = new int[n];
        int current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            coverage[i] = current;
        }

        // Check if each element in nums can be reduced to 0
        for (int i = 0; i < n; i++) {
            if (nums[i] > coverage[i]) {
                return false;
            }
        }

        return true;
    }
}
