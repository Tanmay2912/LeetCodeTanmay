class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        int maxDiag = -1;

        for (int i = 0; i < dimensions.length; i++) {
            int diagSq = dimensions[i][0]*dimensions[i][0] + dimensions[i][1]*dimensions[i][1];
            int area = dimensions[i][0] * dimensions[i][1];

            if (diagSq > maxDiag) {
                maxDiag = diagSq;
                ans = area;
            } else if (diagSq == maxDiag) {
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}
