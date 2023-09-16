class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        for(int i=0;i<nums.length;i++){
            mid = (start + end)/2;
            if(nums[mid] == target)
                return mid;
            if(target<nums[mid]){
               end = mid-1;
            }
            if(target > nums[mid])
               start = mid+1;
        }
       return -1;

    }
}