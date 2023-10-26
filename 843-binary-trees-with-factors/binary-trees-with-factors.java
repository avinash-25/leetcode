class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1000000007;
        int N = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            indexMap.put(arr[i], i);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int complement = arr[i] / arr[j];
                    if (indexMap.containsKey(complement)) {
                        dp[i] = (dp[i] + dp[j] * dp[indexMap.get(complement)]) % MOD;
                    }
                }
            }
        }
        
        long result = 0;
        for (long numTrees : dp) {
            result = (result + numTrees) % MOD;
        }
        
        return (int) result;
    }
}
