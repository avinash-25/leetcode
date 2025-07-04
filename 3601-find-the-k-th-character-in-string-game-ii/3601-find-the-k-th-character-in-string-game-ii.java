class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] lengths = new long[n + 1];
        lengths[0] = 1;

        for (int i = 1; i <= n; i++) {
            lengths[i] = lengths[i - 1] * 2;
            if (lengths[i] >= k) {
                lengths[i] = k; 
            }
        }

        char curr = 'a';
        for (int i = n; i > 0; i--) {
            long half = lengths[i - 1];

            if (k > half) {
                k -= half;
                if (operations[i - 1] == 1) {
                    curr = (char) ((curr - 'a' + 1) % 26 + 'a');
                }
            }
        }
        return curr;
    }
}