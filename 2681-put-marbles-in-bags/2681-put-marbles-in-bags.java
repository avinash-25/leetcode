import java.util.*;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1) return 0; // Only one partition, min == max

        List<Integer> pairSums = new ArrayList<>();
        
        // Compute adjacent pair sums
        for (int i = 0; i < n - 1; i++) {
            pairSums.add(weights[i] + weights[i + 1]);
        }

        // Sort the sums
        Collections.sort(pairSums);

        // Sum the k-1 largest and smallest pairs
        long minScore = 0, maxScore = 0;
        for (int i = 0; i < k - 1; i++) {
            minScore += pairSums.get(i);                      // Smallest (k-1) pairs
            maxScore += pairSums.get(pairSums.size() - 1 - i); // Largest (k-1) pairs
        }

        return maxScore - minScore;
    }
}
