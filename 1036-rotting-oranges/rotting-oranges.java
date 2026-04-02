// class Solution {
//     static class Pair {
//         int row;
//         int col;
//         int tm;
//         public Pair(int row, int col, int tm) {
//             this.row = row;
//             this.col = col;
//             this.tm = tm;
//         }
//     }
//     public int orangesRotting(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int visited[][] = new int[n][m];
//         Queue<Pair> q = new LinkedList<>();
//         int cntfresh = 0;
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < m; j++) {
//                 if(visited[i][j] == 2) {
//                     q.offer(new Pair(i, j, 0));
//                     visited[i][j] = 2;
//                 }
//                 else {
//                     visited[i][j] = 0;
//                 }
//                 if(grid[i][j] == 1) cntfresh++;
//             }
//         }
//         int tm = 0;
//         int delrow[] = {-1, 0, +1, 0};
//         int delcol[] = {0, 1, 0, -1};
//         int cnt = 0;
//         while(!q.isEmpty()) {
//             int r = q.peek().row();
//             int c = q.peek().col();
//             int t = q.peek().tm();
//             tm = Math.max(tm, t);
//             q.remove();
//             for(int i = 0; i < 4; i++) {
//                 int nrow = r+delrow[i];
//                 int ncol = c+delcol[i];
//                 if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[row][col] == 0 && grid[row][col] == 1) {
//                     q.offer(new Pair(nrow, ncol, t+1));
//                     visited[nrow][ncol] = 2;
//                     cnt++;
//                 }
//             }
//         }
//         if(cnt != freshcnt) return -1;
//         return tm;
//     }
// }


class Solution {
    static class Pair {
        int row;
        int col;
        int tm;
        public Pair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {   
                    q.offer(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } 
                else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1) cntFresh++;
            }
        }
        int tm = 0;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int cnt = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;   
            int c = p.col;  
            int t = p.tm;    
            tm = Math.max(tm, t);
            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.offer(new Pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if (cnt != cntFresh) return -1;
        return tm;
    }
}