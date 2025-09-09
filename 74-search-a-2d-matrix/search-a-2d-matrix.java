class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int row=matrix.length;
        // int col=matrix[0].length;
        // int low=0, high=((row*col)-1);

        // while(low<=high)
        // {
        //     int mid=(low+high)/2;
        //     int rowi=mid/col;
        //     int coli=mid%col;

        //     if(matrix[rowi][coli]==target)
        //     {
        //         return true;
        //     }
        //     else if(matrix[rowi][coli]<target)
        //     {
        //         low=mid+1;
        //     }
        //     else
        //     {
        //         high=mid-1;
        //     }
        // }

        // return false;
        
        int m = matrix.length;       
        int n = matrix[0].length;    
        int low = 0, high = m - 1;
        int row = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] == target) {
                return true; 
            } else if (matrix[mid][0] < target) {
                row = mid; 
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (row == -1) return false; 
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}