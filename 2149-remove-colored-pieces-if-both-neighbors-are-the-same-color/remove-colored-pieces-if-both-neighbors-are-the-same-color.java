class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int aliceCount = 0;
        int bobCount = 0;

        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i - 1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A') {
                aliceCount++;
            } else if (colors.charAt(i - 1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B') {
                bobCount++;
            }
        }

        return aliceCount > bobCount;
    }
}
