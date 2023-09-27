class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int current = 1;

        while (current <= n * n) {
            // Fill top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = current++;
            }
            top++;

            // Fill rightmost column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = current++;
            }
            right--;

            // Fill bottom row
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = current++;
            }
            bottom--;

            // Fill leftmost column
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = current++;
            }
            left++;
        }

        return matrix;
    }
}
