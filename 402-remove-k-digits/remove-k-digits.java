class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = num.charAt(i) - '0';
        }
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && st.peek() > arr[i]) {
                st.pop();
                k--;
            }
            st.push(arr[i]);
        }
        // agar k is left even after for loop traveral then remove outside the loop
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        // add the data of stack to stringbuilder 
        StringBuilder sb = new StringBuilder();
        for (int digit : st) {
            sb.append(digit);
        }
        // we need to remove leading zeroes also
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        //return sb.toString();
        return sb.length() == 0 ? "0" : sb.toString();
        
    }
}
