class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;  
        for (int i = 0; i < n; i++) {
            sortDiagonal(grid, i, 0, false);  
        }
        
        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, 0, j, true);   
        }

        return grid;  
    }
    
    public void sortDiagonal(int[][] grid, int row, int col, boolean increasing) {
        int n = grid.length;
        List<Integer> diagonal = new ArrayList<>();  

        int i = row, j = col;
        while (i < n && j < n) {
            diagonal.add(grid[i][j]);  
            i++; 
            j++; 
        }
        
        if (increasing) {
            Collections.sort(diagonal);  
        } else {
            Collections.sort(diagonal, Collections.reverseOrder());  
        }
        
        i = row; 
        j = col;  
        int idx = 0;  
        while (i < n && j < n) {
            grid[i][j] = diagonal.get(idx++);  
            i++; 
            j++;  
        }
    }
}