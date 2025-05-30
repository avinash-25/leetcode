class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        int[] dist1 = getDistances(edges, node1, n);
        int[] dist2 = getDistances(edges, node2, n);

        int minDist = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    result = i;
                }
            }
        }

        return result;
    }

    private int[] getDistances(int[] edges, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        
        int d = 0;
        while (start != -1 && dist[start] == -1) {
            dist[start] = d++;
            start = edges[start];
        }

        return dist;
    }
}
