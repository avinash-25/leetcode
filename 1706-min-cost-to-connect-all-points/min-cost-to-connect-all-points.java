class Solution {
    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, cost});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[2], b[2]));

        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int connectedPoints = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
                totalCost += cost;
                connectedPoints++;
                if (connectedPoints == n - 1) {
                    break;
                }
            }
        }

        return totalCost;
    }
}
