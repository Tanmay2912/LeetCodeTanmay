class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<>();
        int ans[] = new int[nums1.length];
        int j = nums1.length-1;
        for(int i = nums2.length-1; i >= 0; i--) {
            int curr = nums2[i];
            while(!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }
            if(st.isEmpty()) {
                mp.put(curr, -1);
            }
            else {
                mp.put(curr, st.peek());
            }
            st.push(curr);
        }
        int nge[] = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            nge[i] = mp.get(nums1[i]);
        }
        return nge;
    }
}