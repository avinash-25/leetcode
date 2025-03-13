class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int left = 0, right = m, answer = -1;

        // Binary search for minimum k
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeZero(nums, queries, mid, n)) {
                answer = mid;
                right = mid - 1; // Try a smaller k
            } else {
                left = mid + 1; // Try a larger k
            }
        }

        return answer;
    }

    private boolean canMakeZero(int[] nums, int[][] queries, int k, int n) {
        int[] diff = new int[n + 1]; // Difference array for efficient range updates

        // Apply first k queries to the difference array
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] -= val;
            if (r + 1 < n) diff[r + 1] += val; // End range compensation
        }

        // Compute final nums using the difference array
        int[] modifiedNums = nums.clone(); // Copy original nums
        int decrement = 0;

        for (int i = 0; i < n; i++) {
            decrement += diff[i]; // Apply the difference effect
            modifiedNums[i] += decrement; // Update nums[i]

            // If any number is still greater than 0, return false
            if (modifiedNums[i] > 0) {
                return false;
            }
        }

        return true; // Successfully made all elements zero
    }
}
