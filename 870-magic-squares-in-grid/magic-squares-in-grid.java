class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (rows < 3 || cols < 3) return 0; // base condition

        int cnt = 0;

        // for checking all 3 X 3 matrices
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (checkMat(grid, i, j)) cnt++;
            }
        }
        return cnt;
    }

    private static boolean checkMat(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10]; // numbers must be in range(1 - 10)
        int[] sums = new int[8]; // 3 rows, 3 cols, 2 diagonals

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j]; // check in the curr matrix
                if (num < 1 || num > 9 || seen[num]) return false;
                seen[num] = true;

                sums[i] += num; // for row sum
                sums[3 + j] += num; // for col sum
                
                if (i == j) sums[6] += num;        // for checking diagonal sum
                if (i + j == 2) sums[7] += num;   // for checking antidiagonal sum
            }
        }

       
        for (int sum : sums) {
            if (sum != 15) return false; // all the sums must be 15
        }
        return true;
    }
}