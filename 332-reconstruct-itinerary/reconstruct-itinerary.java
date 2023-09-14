class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> result = new ArrayList<>();

        // Build the graph from the given tickets
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        // Perform DFS starting from "JFK"
        dfs("JFK", graph, result);

        // Reverse the result as we start from "JFK"
        Collections.reverse(result);
        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> neighbors = graph.get(airport);

        while (neighbors != null && !neighbors.isEmpty()) {
            // Visit the smallest lexical order neighbor
            String nextAirport = neighbors.poll();
            dfs(nextAirport, graph, result);
        }

        // Add the current airport to the result list
        result.add(airport);
    }
}
