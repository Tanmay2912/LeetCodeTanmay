class Solution {
    public void dfs(int u, List<Integer>[] adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        // Convert each property array to a set 
        Set<Integer>[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
            for (int num : properties[i]) {
                sets[i].add(num);
            }
        }
        // Build adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // Check all pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> temp = new HashSet<>(sets[i]);
                temp.retainAll(sets[j]); // intersection
                if (temp.size() >= k) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        // Count connected components using DFS
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }
}