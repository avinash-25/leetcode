class Solution {
    public int strStr(String haystack, String needle) {
        int len2 = needle.length();
        int len1 = haystack.length();

        for (int i = 0; i <= len1 - len2; i++) {
            int j = 0;
            while (j < len2 && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == len2) {
                return i;
            }
        }
        return -1;
    }
}
