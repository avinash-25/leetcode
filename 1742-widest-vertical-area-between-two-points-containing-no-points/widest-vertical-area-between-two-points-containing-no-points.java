class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int mx = 0;
        Arrays.sort(points,(a,b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int i=1; i<points.length; i++){
            mx = Math.max(mx,points[i][0]-points[i-1][0]);
        }
        return mx;
    }
}