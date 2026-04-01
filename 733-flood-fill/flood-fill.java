class Solution {
    public static boolean isValid(int i, int j, int n, int m) {
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;
        return true;
    }
    public static void dfs(int sr, int sc, int ans[][], int image[][], int color, int inic) {
        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        // stored the chnage in row column to traverse in direction
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, 1, 0, -1};
        // traverse the 4 neightbour
        for(int i = 0; i < 4; i++) {
            int nrow = sr + delRow[i];
            int ncol = sc + delCol[i];
            if(isValid(nrow, ncol, n, m) && ans[nrow][ncol] == inic && ans[nrow][ncol] != color) {
                // made a dfs call if all condition satisfied 
                dfs(nrow, ncol, ans, image, color, inic);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inic = image[sr][sc];
        if(inic == color) return image;
        int ans[][] = new int[image.length][image[0].length];
        // made a duplicate ans array
        for (int i = 0; i < image.length; i++) {
            ans[i] = Arrays.copyOf(image[i], image[i].length);
        }
        // used dfs traversal but we can use bfs also
        dfs(sr, sc, ans, image, color, inic);
        return ans;
    }
    
}