import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        int length = 0;
        boolean hasCenter = false;

        for (String word : countMap.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();

           
            if (word.equals(rev)) {
                int pairs = countMap.get(word) / 2;
                length += pairs * 4; 
                if (countMap.get(word) % 2 == 1) {
                    hasCenter = true; 
                }
            } 
            
            else if (countMap.containsKey(rev)) {
                int pairs = Math.min(countMap.get(word), countMap.get(rev));
                length += pairs * 4;
                
                countMap.put(word, 0);
                countMap.put(rev, 0);
            }
        }

        if (hasCenter) {
            length += 2; 
        }

        return length;
    }
}
