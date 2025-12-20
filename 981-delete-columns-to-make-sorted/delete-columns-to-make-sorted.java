class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int delCol = 0;
        char mat[][] = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                mat[i][j] = strs[i].charAt(j);
            }
        }
        for(int i = 0; i < m; i++) { // columns
            for(int j = 1; j < n; j++) { // rows
                if(mat[j][i] < mat[j-1][i]) { // agar current wala chota hai pichle wale se
                    delCol ++;
                    break; // taki iss current col ko fir na count kare
                }
            }  
        }
        return delCol;
    }
}