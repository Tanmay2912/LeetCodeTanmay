// class Solution {
//     public boolean canFinish(int n, int[][] prerequisites) {
//         List<Integer>[] adj = new List[n];
//         int[] indegree = new int[n];
//         List<Integer> ans = new ArrayList<>();
//         for (int[] pair : prerequisites) {
//             int course = pair[0];
//             int prerequisite = pair[1];
//             if (adj[prerequisite] == null) {
//                 adj[prerequisite] = new ArrayList<>();
//             }
//             adj[prerequisite].add(course);
//             indegree[course]++;
//         }
//         Queue<Integer> queue = new LinkedList<>();
//         for (int i = 0; i < n; i++) {
//             if (indegree[i] == 0) {
//                 queue.offer(i);
//             }
//         }
//         while (!queue.isEmpty()) {
//             int current = queue.poll();
//             ans.add(current);

//             if (adj[current] != null) {
//                 for (int next : adj[current]) {
//                     indegree[next]--;
//                     if (indegree[next] == 0) {
//                         queue.offer(next);
//                     }
//                 }
//             }
//         }
//         return ans.size() == n;
//     }
// }
class Solution {
    public boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] pathVis, int[] visited) {
        visited[node] = 1;
        pathVis[node] = 1;
        for(int it : adj.get(node)) {
            if(visited[it] == 0) {
                if(dfsCheck(it, adj, pathVis, visited)) {
                    return true;
                }
            }
            else if(pathVis[it] == 1) {
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        int visited[] = new int[n];
        int pathVis[] = new int[n];
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                if(dfsCheck(i, adj, pathVis, visited) == true) 
                    return false;
            }
        }
        return true;
    }
}