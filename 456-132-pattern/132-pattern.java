import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }

        int[] minArray = new int[len];
        minArray[0] = nums[0];

        
        for (int i = 1; i < len; i++) {
            minArray[i] = Math.min(minArray[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
        
            if (nums[i] > minArray[i]) {
                while (!stack.isEmpty() && stack.peek() <= minArray[i]) {
                    stack.pop();
                }
               
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }

        return false;
    }
}
