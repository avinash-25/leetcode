class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sPointer = s.length() - 1;
        int tPointer = t.length() - 1;
        int sBackspace = 0;
        int tBackspace = 0;

        while (sPointer >= 0 || tPointer >= 0) {
            // Find the position of the next non-backspace character in s.
            while (sPointer >= 0 && (s.charAt(sPointer) == '#' || sBackspace > 0)) {
                if (s.charAt(sPointer) == '#') {
                    sBackspace++;
                } else {
                    sBackspace--;
                }
                sPointer--;
            }

            // Find the position of the next non-backspace character in t.
            while (tPointer >= 0 && (t.charAt(tPointer) == '#' || tBackspace > 0)) {
                if (t.charAt(tPointer) == '#') {
                    tBackspace++;
                } else {
                    tBackspace--;
                }
                tPointer--;
            }

            // Compare the current characters in s and t.
            if (sPointer >= 0 && tPointer >= 0 && s.charAt(sPointer) != t.charAt(tPointer)) {
                return false;
            }

            // If one string has reached the beginning while the other hasn't, they are not equal.
            if ((sPointer >= 0 && tPointer < 0) || (sPointer < 0 && tPointer >= 0)) {
                return false;
            }

            sPointer--;
            tPointer--;
        }

        return true;
    }
}
