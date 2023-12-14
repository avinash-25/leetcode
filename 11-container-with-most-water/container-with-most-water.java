class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        int h1 = 0,h2 = 0, h=0,width=0,area=0;

        while (left < right) {
             h1 = height[left];
             h2 = height[right];
             h = Math.min(h1, h2);
             width = right - left;
             area = h * width;
            maxArea = Math.max(maxArea, area);

            if (h1 < h2) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}