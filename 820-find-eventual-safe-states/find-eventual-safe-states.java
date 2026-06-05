//terminal means no outgoing edge
//this is a dfs based solution 
//in this if any node appears in a cycle then it is not safe
class Solution {
    public boolean dfs(int node, int[][] graph, int visited[], int pathVis[], int check[]) {
        visited[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        for(int it : graph[node]) {
            if(visited[it] == 0) {
                if(dfs(it, graph, visited, pathVis, check)) {
                    pathVis[node] = 0;
                    return true;
                }
            }
            else if(pathVis[it] == 1) {
                pathVis[node] = 0;
                return true;
            }
            else {
                if(check[it] == 0) {
                    pathVis[node] = 0;
                    return true;
                }
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int visited[] = new int[graph.length];
        int pathVis[] = new int[graph.length];
        int check[] = new int[graph.length];
        ArrayList<Integer> safeNode = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            if(visited[i] == 0) {
                dfs(i, graph, visited, pathVis, check);
            }
            
        }
        for(int i = 0; i < graph.length; i++) {
            if(check[i] == 1) {
                safeNode.add(i);
            }
        }
        Collections.sort(safeNode);
        return safeNode;
    }
}