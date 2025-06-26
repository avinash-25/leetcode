class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        int n = s.length();
        int zeros = 0;
        long value = 0;
        long power = 1;

        
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

       
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '1') {
                if (power > k) break;
                value += power;
                if (value <= k) {
                    count++;
                } else {
                    break;
                }
                power *= 2;
            } else {
                power *= 2; 
            }
            
            if (power > 1_000_000_000L) break;
        }

        return zeros + count;
    }
}
