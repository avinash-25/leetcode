class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100_005; 

    long[] fact = new long[MAX];
    long[] invFact = new long[MAX];

    public int countGoodArrays(int n, int m, int k) {
        precomputeFactorials(n);

        long result = (long) m * comb(n - 1, k) % MOD;
        result = result * modPow(m - 1, n - 1 - k) % MOD;
        return (int) result;
    }

    
    void precomputeFactorials(int n) {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[n] = modInverse(fact[n]);
        for (int i = n - 1; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    
    long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    
    long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = res * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }

    long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
}
