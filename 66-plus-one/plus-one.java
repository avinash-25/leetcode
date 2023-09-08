class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Add 1 to the current digit
            digits[i]++;
            
            // If the digit becomes 10, carry over to the next digit
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                // If it's not 10, no need to carry over, so return the updated array
                return digits;
            }
        }
        
        // If we reach here, it means all digits were 9 and we need to add a new leading digit 1
        int[] result = new int[n + 1];
        result[0] = 1; // Set the first digit to 1
        return result;
    }
}
