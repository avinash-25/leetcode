class Solution {
    public int numSpecial(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int count=0;
        int[] row=new int[n];
        int[] col=new int[m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (mat[i][j]==1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int k=0;k<n;k++) {
            for (int l=0;l<m;l++) {
                if (mat[k][l]==1&&row[k]==1&&col[l]==1) {
                    count++;
                }
            }
        }
        return count;
    }
}