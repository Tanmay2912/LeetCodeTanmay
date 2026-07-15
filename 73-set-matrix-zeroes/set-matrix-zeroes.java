/*class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int cols[]=new int[col];
        int rows[]=new int[row];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(matrix[i][j]==0) {
                    rows[i]=1;
                    cols[j]=1;
                }
            }
        }
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(cols[j]==1 || rows[i]==1) {
                    matrix[i][j]=0;
                }
            }
        }
    }
}*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int markR[] = new int[row];
        int markC[] = new int[col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 0) {
                    markR[i] = 1;
                    markC[j] = 1;
                }
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(markC[j] == 1|| markR[i] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}