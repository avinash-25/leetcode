class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int max_i_plus_val = values[0];

        for (int j = 1; j < values.length; j++) {
            maxScore = Math.max(maxScore, max_i_plus_val + values[j] - j);
            max_i_plus_val = Math.max(max_i_plus_val, values[j] + j);
        }

        return maxScore;
    }
}
