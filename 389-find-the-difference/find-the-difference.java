class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26]; // Assuming only lowercase letters are present
        
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
        }
        
        for (char c : t.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                return (char) ('a' + i);
            }
        }
        
        return 'h'; // If the function doesn't find any difference
    }
}
