class Solution {
    static final int MOD = 1_000_000_007;
    int maxN = 10000;
    long[] fact = new long[maxN + 1];
    long[] invFact = new long[maxN + 1];

    public int idealArrays(int n, int maxValue) {
        precomputeFactorials(n);

        // dp[i] = number of sequences ending with value i
        // dpLen[i][len] = number of sequences of length len ending with i
        int[][] dpLen = new int[maxValue + 1][15]; // depth won't go more than ~14

        for (int i = 1; i <= maxValue; i++) {
            dpLen[i][1] = 1; // base case: length 1 sequence starting at i
        }

        // Build sequences using DP
        for (int len = 2; len <= 14; len++) {
            for (int i = 1; i <= maxValue; i++) {
                for (int mult = 2; i * mult <= maxValue; mult++) {
                    dpLen[i * mult][len] = (dpLen[i * mult][len] + dpLen[i][len - 1]) % MOD;
                }
            }
        }

        long res = 0;
        for (int i = 1; i <= maxValue; i++) {
            for (int len = 1; len <= 14; len++) {
                if (dpLen[i][len] == 0) continue;
                long ways = comb(n - 1, len - 1);
                res = (res + ways * dpLen[i][len]) % MOD;
            }
        }

        return (int) res;
    }

    private void precomputeFactorials(int n) {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[maxN] = modInverse(fact[maxN]);
        for (int i = maxN - 1; i >= 1; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    private long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long x, int p) {
        long res = 1;
        while (p > 0) {
            if ((p & 1) == 1) res = res * x % MOD;
            x = x * x % MOD;
            p >>= 1;
        }
        return res;
    }
}
