import java.util.*;
// import java.util.HashMap;
// import java.util.Map;

class Solution {
    public int longestStrChain(String[] words) {
        // Sort the words by length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        // Create a map to store the longest chain length for each word
        Map<String, Integer> chainLength = new HashMap<>();
        int maxLength = 1; // Initialize with a minimum length of 1
        
        for (String word : words) {
            int currentLength = 1; // Initialize with a minimum length of 1
            
            // Try to remove one character from the word and find the longest chain length
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String prevWord = sb.toString();
                
                if (chainLength.containsKey(prevWord)) {
                    currentLength = Math.max(currentLength, chainLength.get(prevWord) + 1);
                }
            }
            
            chainLength.put(word, currentLength);
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}
