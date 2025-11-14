import java.util.*;
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0; i<n; i++)list.add(new ArrayList<>());
        for(int[] i:edges){
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        boolean[] arr=new boolean[n];
        dfs(source,arr, list);
        return arr[destination];
    }
    private void dfs(int src, boolean[] arr, List<List<Integer>> list){
        arr[src]=true;
        List<Integer> l=list.get(src);
        for(int i:l){
            if(!arr[i])dfs(i,arr,list);
        }
    }
}



