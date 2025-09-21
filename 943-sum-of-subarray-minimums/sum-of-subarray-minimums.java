class Solution {
    public int[] findNextSmallerEle(int[] arr) {
        int[] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] findPreviousSmallerEle(int[] arr) {
        int[] pse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNextSmallerEle(arr);
        int[] pse = findPreviousSmallerEle(arr);
        long total = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            long freq = left * right;
            total = (total + (freq * arr[i]) % mod) % mod;
        }
        return (int) total;
    }
}

// class solution {
//     public int[] findNextGreaterEle(int[] arr) {
//         int[] nge = new int[arr.length];
//         Stack<Integer> st = new Stack<>();
//         for(int i = arr.length-1; i >= 0; i--) {
//             while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
//                 st.pop();
//             }
//             nge[i] = st.isEmpty() ? arr.length : st.peek();
//             st.push(i);
//         }
//         return nge;
//     }
//     public int[] findPreviousSmallEle(int[] arr) {
//         int[] pse = new int[arr.length];
//         Stack<Integer> st = new Stack<>();
//         for(int i = 0; i < arr.length; i++) {
//             while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
//                 st.pop();
//             }
//             pse[i] = st.isEmpty() ? -1 : st.peek();
//             st.push(i);
//         }
//         return pse;
//     }
//     public int sumSubarrayMins(int[] arr) {
//         int[] nse = new int[arr.length];
//         int[] pse = new int[arr.length];
//         nse = findNextGreaterEle(arr);
//         pse = findPreviousSmallEle(arr);
//         int total = 0;
//         int mod = (int)1e9 + 7;
//         for(int i = 0; i < arr.length; i++) {
//             int left = i - pse[i];
//             int right = nse[i] - i;
//             long freq = left*right*1L;
//             int val = (int)( (freq * arr[i]) % mod);
//             total = (total + val) % mod;
//         }
//         return total;
//     } 
// }

// class Solution {
//     public void generateSubarrays(int[] arr, int start, int end, List<List<Integer>> ans) {
//         int n = arr.length;
//         if (end == n) return;
//         if (start > end) {
//             generateSubarrays(arr, 0, end + 1, ans);
//             return;
//         }
//         List<Integer> sub = new ArrayList<>();
//         for (int i = start; i <= end; i++) {
//             sub.add(arr[i]);
//         }
//         ans.add(sub);
//         generateSubarrays(arr, start + 1, end, ans);
//     }
//     public int findMinList(List<Integer> subarr) {
//         int min = subarr.get(0);
//         for(int i = 0; i < subarr.size(); i++) {
//             min = Math.min(min, subarr.get(i));
//         }
//         return min;
//     }
//     public int sumSubarrayMins(int[] arr) {
//         List<List<Integer>> subArrs = new ArrayList<>();
//         generateSubarrays(arr, 0, 0, subArrs);
//         int sum = 0;
//         for(List<Integer> subarr : subArrs) {
//             sum += findMinList(subarr);
//         }
//         return sum;
//     }
// }