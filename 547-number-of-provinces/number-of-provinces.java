class Solution {
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
}