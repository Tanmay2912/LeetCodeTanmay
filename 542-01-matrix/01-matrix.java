/*class Solution {
    static class Pair {
        int i, j, dist;
        Pair(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int visited[][] = new int[n][m];
        int result[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
                else {
                    visited[i][j] = 0;
                }
            }
        }
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};
        while(!q.isEmpty()) {
            int row = q.peek().i;
            int col = q.peek().j;
            int dist = q.peek().dist;
            q.remove();
            result[row][col] = dist;
            for(int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0) {
                    q.add(new Pair(nrow, ncol , dist+1));
                    visited[nrow][ncol] = 1;
                }
            }
        }
        return result;
    }
}*/

class Solution {
    class Pair {
        int i;
        int j;
        int dist;
        public Pair(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int visited[][] = new int[n][m];
        int result[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
                else {
                    visited[i][j] = 0;
                }
            }
        }
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};
        while(!q.isEmpty()) {
            int row = q.peek().i;
            int col = q.peek().j;
            int dist = q.peek().dist;
            q.remove();
            result[row][col] = dist;
            for(int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0) {
                    q.add(new Pair(nrow, ncol, dist+1));
                    visited[nrow][ncol] = 1;
                }
            }
        }
        return result;
    }
}