class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // Build adjacency list with weights
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Fill adjacency list (undirected graph)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        
        // Array to store component ID for each vertex
        int[] component = new int[n];
        Arrays.fill(component, -1);
        
        // Array to store minimum AND value for each component
        int[] minAnd = new int[n];
        Arrays.fill(minAnd, -1);
        
        // DFS to find connected components and compute minimum AND
        int compId = 0;
        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                // Start with maximum possible value for bitwise AND
                int[] andValue = new int[]{Integer.MAX_VALUE};
                dfs(i, graph, component, compId, andValue);
                minAnd[compId] = andValue[0];
                compId++;
            }
        }
        
        // Process queries
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int s = query[i][0];
            int t = query[i][1];
            
            // If in different components, no path exists
            if (component[s] != component[t]) {
                answer[i] = -1;
            } else {
                // If in same component, answer is the minimum AND value of that component
                answer[i] = minAnd[component[s]];
            }
        }
        
        return answer;
    }
    
    private void dfs(int vertex, List<int[]>[] graph, int[] component, 
                    int compId, int[] andValue) {
        component[vertex] = compId;
        
        // Process all adjacent vertices
        for (int[] neighbor : graph[vertex]) {
            int next = neighbor[0];
            int weight = neighbor[1];
            
            // Update minimum AND value for this component
            andValue[0] &= weight;
            
            // Continue DFS if vertex not visited
            if (component[next] == -1) {
                dfs(next, graph, component, compId, andValue);
            }
        }
    }
}