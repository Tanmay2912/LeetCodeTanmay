/*class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1 && i!=j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean visited[] = new boolean[isConnected.length+1];
        int cnt = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(visited[i] == false) {
                dfs(adj, visited, i);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], int node) {
        visited[node] = true;
        for(Integer it : adj.get(node)) {
            if(visited[it] == false) {
                dfs(adj, visited, it);
            }
        }
    }
}*/

class Solution {
    public void bfsTraversal(ArrayList<ArrayList<Integer>> adj, Queue<Integer> q, boolean visited[], int node) {
        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()) {
            int vertex = q.peek();
            q.remove();
            for(int it : adj.get(vertex)) {
                if(visited[it] == false) {
                    q.offer(it);
                    visited[it] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected[0].length; j++) {
                if(isConnected[i][j] == 1 && j!=i) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(visited[i] == false) {
                count += 1;
                bfsTraversal(adj, q, visited, i);
            }
        }
        return count;
    }
}