class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[101][101]; // Initialize a 2D array to represent the glasses

        glasses[0][0] = (double)poured; // Pour the initial champagne into the top glass

        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double overflow = (glasses[i][j] - 1.0) / 2.0; // Calculate the overflow
                if (overflow > 0) {
                    glasses[i + 1][j] += overflow; // Distribute overflow to the left glass below
                    glasses[i + 1][j + 1] += overflow; // Distribute overflow to the right glass below
                }
            }
        }

        // Ensure the result is between 0 and 1
        return Math.min(1.0, glasses[query_row][query_glass]);
    }
}
