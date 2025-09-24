class Solution {
    public int[] findNSE(int[] heights) {
        int nse[] = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        for (int i = heights.length-1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nse[i] = heights.length;  
            } else {
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }
    public int[] findPSE(int[] heights) {
        int pse[] = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                pse[i] = -1; 
            } else {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }
    public int largestRectangleArea(int[] heights) {
        int nse[] = new int[heights.length];
        int pse[] = new int[heights.length];
        nse = findNSE(heights);
        pse = findPSE(heights);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nse[i]-pse[i]-1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}