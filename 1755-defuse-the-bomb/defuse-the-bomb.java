class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];
        // agar k 0 hai tho 0 ka hi array return kar do
        if(k == 0) {
            Arrays.fill(ans, 0);
            return ans;
        }
        // ek circular array bana lo simple of size 2n aur i+n will be i only
        int circular[] = new int[2*n];
        for(int i = 0; i < n; i++) {
            circular[i] = code[i];
            circular[i+n] = code[i];
        }
        
        if(k > 0) {
            // j ko 1 liya hai kyuki uss element ko include nhi karna hai sum meh next element 
            int sum = 0, i = 0, j = 1; 
            // initialize first window pahla sum nikal lo
            while(j <= k) {
                sum += circular[j];
                j++;
            }
            // first window hi hai tho i = 0 ab j 2n tak jayega lekin i n tak hi rahega kyuki utna hi chahiye hame
            i = 0;
            while(i < n) {
                ans[i] = sum;
                // remove first element of window, add next element
                sum = sum - circular[i + 1] + circular[i + k + 1];
                i++;
            }
        }
        else {
            k = -k;
            // is baar j ko n-k kiya hai kyuki previous elements ka sum chahaiye
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
