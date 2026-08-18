class Solution { 
    public void nextSmallerElement(int[] arr, int[] nse) { 
        Stack<Integer> st = new Stack<>(); 
        for(int i = arr.length - 1; i >= 0; i--) { 
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) { 
                st.pop(); 
            } 
            if(st.isEmpty()) { 
                nse[i] = arr.length;   // right boundary
            } 
            else { 
                nse[i] = st.peek();    // index
            } 
            st.push(i); 
        } 
    } 
    public void previousSmallerElement(int[] arr, int[] pse) { 
        Stack<Integer> st = new Stack<>(); 
        for(int i = 0; i < arr.length; i++) { 
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) { 
                st.pop(); 
            } 
            if(st.isEmpty()) { 
                pse[i] = -1;           // left boundary
            } 
            else { 
                pse[i] = st.peek();    // index
            } 
            st.push(i); 
        } 
    } 
    public int sumSubarrayMins(int[] arr) { 
        int nse[] = new int[arr.length]; 
        int pse[] = new int[arr.length]; 
        nextSmallerElement(arr, nse); 
        previousSmallerElement(arr, pse); 
        long total = 0; 
        int mod = (int) 1e9 + 7; 
        for(int i = 0; i < arr.length; i++) { 
            long left = i - pse[i]; 
            long right = nse[i] - i; 
            long freq = left * right; 
            total = (total + (freq * arr[i]) % mod) % mod; 
        } 
        return (int)total; 
    } 
}