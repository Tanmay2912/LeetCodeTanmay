class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];
        if(k == 0) {
            Arrays.fill(ans, 0);
            return ans;
        }
        
        int circular[] = new int[2*n];
        for(int i = 0; i < n; i++) {
            circular[i] = code[i];
            circular[i+n] = code[i];
        }
        
        if(k > 0) {
            int sum = 0, i = 0, j = 1; // start j from i+1 for "next k elements"
            // initialize first window
            while(j <= k) {
                sum += circular[j];
                j++;
            }
            
            i = 0;
            while(i < n) {
                ans[i] = sum;
                // slide window: remove first element of window, add next element
                sum = sum - circular[i + 1] + circular[i + k + 1];
                i++;
            }
        }
        else {
            k = -k;
            int sum = 0, i = 0, j = n - k;
            // initialize first window of previous k elements
            while(j < n) {
                sum += circular[j];
                j++;
            }
            
            i = 0;
            j = n;
            while(i < n) {
                ans[i] = sum;
                // slide window: remove first element of window, add next element
                sum = sum - circular[i + n - k] + circular[j];
                i++;
                j++;
            }
        }
        return ans;
    }
}
