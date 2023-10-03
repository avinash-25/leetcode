class Solution {
    public boolean isGood(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] count = new int[max + 1];
        
        for (int num : nums) {
            if (num < 1 || num > max) {
                return false;
            }
            count[num]++;
        }
        
        for (int i = 1; i < max; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        
        if (count[max] != 2) {
            return false;
        }
        
        for (int i = 1; i <= max; i++) {
            if (count[i] > 2) {
                return false;
            }
        }
        
        return true;
    }
}

