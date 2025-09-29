class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // check if u and v are already connected using DFS
            boolean[] visited = new boolean[n + 1];
            if (dfs(graph, u, v, visited)) {
                // if already connected, this edge is redundant
                return edge;
            }

            // else add edge to graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0];
    }

    private boolean dfs(List<List<Integer>> graph, int src, int target, boolean[] visited) {
        if (src == target) return true;
        visited[src] = true;
        for (int nei : graph.get(src)) {
            if (!visited[nei] && dfs(graph, nei, target, visited)) {
                return true;
            }
        }
        return false;
    }
}
