import java.util.*;

class Solution {
    public int func(int idx, String s, Set<String> st, int[] dp) {
        if (idx == s.length())
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int res = Integer.MAX_VALUE;
        for (int j = idx; j < s.length(); ++j) {
            String str = s.substring(idx, j + 1);
            if (st.contains(str))
                res = Math.min(res, 0 + func(j + 1, s, st, dp));
            else
                res = Math.min(res, j - idx + 1 + func(j + 1, s, st, dp));
        }
        return dp[idx] = res;
    }

    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        Set<String> st = new HashSet<>(Arrays.asList(dictionary));
        return func(0, s, st, dp);
    }
}