class Solution {
    public boolean isSubsequence(String s, String t) {
        int k = 0;
        int count = 0;

        while (k < t.length() && count < s.length()) {
            if (s.charAt(count) == t.charAt(k)) {
                count++;
            }
            k++;
        }

        return count == s.length();
    }
}