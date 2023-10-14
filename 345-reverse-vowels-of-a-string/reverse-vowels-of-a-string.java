class Solution {
    public String reverseVowels(String s) {
        char[] vowels = "aeiouAEIOU".toCharArray();
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !isVowel(charArray[left], vowels)) {
                left++;
            }
            while (left < right && !isVowel(charArray[right], vowels)) {
                right--;
            }
            
            if (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }

        return new String(charArray);
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
