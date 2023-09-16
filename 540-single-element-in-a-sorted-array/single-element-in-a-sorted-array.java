class Solution{
public int singleNonDuplicate(int[] nums) {
    int left = 0;
    int right = nums.length - 1,mid=0;

    while (left < right) {
        mid = left + (right - left) / 2;

        if (mid % 2 == 1) {
            mid--;
        }
        if (nums[mid] != nums[mid + 1]) {
            right = mid;
        } else {
            left = mid + 2;
        }
    }

    return nums[left];
    }
}