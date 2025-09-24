/*class Solution {
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
        for(int i = 0; i < heights.length; i++) {
            System.out.print(nse[i] + " ");
        }
        for(int i = 0; i < heights.length; i++) {
            System.out.print(pse[i] + " ");
        }
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nse[i]-pse[i]-1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int nse, pse;
        int maxArea = 0, area = 0;
        for(int i = 0; i < heights.length; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int idx = st.pop();
                pse = st.isEmpty() ? -1 : st.peek();
                nse = i;
                area = heights[idx] * (nse-pse-1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            nse = heights.length;
            int idx = st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            area = heights[idx] * (nse-pse-1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}