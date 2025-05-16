import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        int[] dp = new int[n];       // dp[i] = length of longest chain ending at i
        int[] prev = new int[n];     // prev[i] = previous index in chain
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        // Compare every valid pair (O(n^2)) but no extra memory usage
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    hamming(words[i], words[j]) == 1) {
                    
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }

        // Find index of max dp value
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        // Reconstruct result path
        LinkedList<String> result = new LinkedList<>();
        int curr = maxIdx;
        while (curr != -1) {
            result.addFirst(words[curr]);
            curr = prev[curr];
        }

        return result;
    }

    // Check if two same-length strings differ by exactly 1 character
    private int hamming(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++diff > 1) return diff;
            }
        }
        return diff;
    }
}
