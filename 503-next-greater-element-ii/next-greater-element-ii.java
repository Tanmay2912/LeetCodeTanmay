class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums.length];
        for(int i = 2*nums.length-1; i >= 0; i--) {
            int idx = i%nums.length;
            while(!st.isEmpty() && st.peek() <= nums[idx]) {
                st.pop();
            }
            if(i < nums.length) {
                if(st.isEmpty()) {
                    ans[idx] = -1;
                }
                else {
                    ans[idx] = st.peek();
                }
            }
            st.push(nums[idx]);
        }
        return ans;
    }
}