class Solution { 
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // initialize adjacency list
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // build graph (already adjacency list given)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        int color[] = new int[n];
        Arrays.fill(color, -1);
        // handle disconnected components
        for(int i = 0; i < n; i++) {
            if(color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 0;
                while(!q.isEmpty()) {
                    int node = q.peek();
                    q.remove();
                    for(Integer it : adj.get(node)) {
                        if(color[it] == -1) {
                            color[it] = 1 - color[node]; // opposite color
                            q.offer(it);
                        } 
                        else if(color[it] == color[node]) {
                            return false; // same color conflict
                        }
                    }
                }
            }
        }
        return true;
    }
}