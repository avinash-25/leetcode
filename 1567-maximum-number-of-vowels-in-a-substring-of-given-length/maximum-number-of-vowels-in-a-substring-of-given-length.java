class Solution {
    public int maxVowels(String s, int k) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int maxVowelCount = 0;
        int currentVowelCount = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i), vowels)) {
                currentVowelCount++;
            }
        }
        maxVowelCount = currentVowelCount;

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i), vowels)) {
                currentVowelCount++;
            }
            if (isVowel(s.charAt(i - k), vowels)) {
                currentVowelCount--;
            }
            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
        }

        return maxVowelCount;
    }

    private boolean isVowel(char c, char[] vowels) {
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }
}
