//This approach fails because the graph can be disconnected also hence we need take care of that also
/*class Solution {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> q = new LinkedList<>();
        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color, -1);
        q.offer(0);
        color[0] = 1;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for(int it : graph[node]) {
                if(color[it] == -1) {
                    q.offer(it);
                    color[it] = 1-color[node];
                }
                else if(color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}*/

class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color, -1);
        // to handle disconnected componenets
        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 0;
                while(!q.isEmpty()) {
                    int node = q.poll();
                    for(int it : graph[node]) {
                        // agar color nhi mila hai tho node se alag color de do
                        if(color[it] == -1) {
                            color[it] = 1 - color[node];
                            q.offer(it);
                        }
                        // agar color mil chuka hai tho check kar lo ki kahin color same tho nhi
                        else if(color[it] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}