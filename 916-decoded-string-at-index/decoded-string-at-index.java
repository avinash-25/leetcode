class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0; // Initialize the decoded length as a long to avoid overflow
        
        // Calculate the total length of the decoded string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                decodedLength *= digit;
            } else {
                decodedLength++;
            }
        }
        
        // Start decoding from the end of the string
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                int digit = c - '0';
                decodedLength /= digit;
                k %= decodedLength; // Reduce k to a relative index within the current repeated sequence
                
            } else {
                if (k == 0 || k == decodedLength) {
                    return Character.toString(c);
                }
                decodedLength--;
            }
        }
        
        return null; // This line should never be reached
    }
}
