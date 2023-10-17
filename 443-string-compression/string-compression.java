class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int n = chars.length;

        for (int i = 0; i < n; ) {
            char currentChar = chars[i];
            int count = 0;

            while (i < n && chars[i] == currentChar) {
                i++;
                count++;
            }
            chars[index++] = currentChar;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char digit : countStr.toCharArray()) {
                    chars[index++] = digit;
                }
            }
        }

        return index;
    }
}
