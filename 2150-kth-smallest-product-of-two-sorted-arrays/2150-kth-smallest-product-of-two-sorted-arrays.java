class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -1_000_000_0000L, right = 1_000_000_0000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countProducts(nums1, nums2, mid) < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private long countProducts(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int num1 : nums1) {
            if (num1 == 0) {
                if (target >= 0) count += nums2.length;
                continue;
            }
            int low = 0, high = nums2.length;
            if (num1 > 0) {
                while (low < high) {
                    int mid = (low + high) / 2;
                    if ((long) num1 * nums2[mid] <= target)
                        low = mid + 1;
                    else
                        high = mid;
                }
                count += low;
            } else {
                while (low < high) {
                    int mid = (low + high) / 2;
                    if ((long) num1 * nums2[mid] <= target)
                        high = mid;
                    else
                        low = mid + 1;
                }
                count += nums2.length - low;
            }
        }
        return count;
    }
}