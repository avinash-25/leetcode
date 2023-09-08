class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }
        
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
