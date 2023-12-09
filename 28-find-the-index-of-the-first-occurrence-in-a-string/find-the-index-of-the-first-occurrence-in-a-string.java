class Solution {
    public int strStr(String haystack, String needle) {
        int len2 = needle.length();
        int len1 = haystack.length();

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < len2 && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
