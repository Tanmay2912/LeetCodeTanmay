class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            if(st.isEmpty()) {
                st.push(asteroids[i]);
            }
            else if(asteroids[i] > 0) {
                st.push(asteroids[i]);
            }
            else if(asteroids[i] < 0 ) {
                int val = Math.abs(asteroids[i]);
                boolean destroyed = false;
                while(!st.isEmpty() && st.peek() > 0) {
                    if(st.peek() < val) {
                        st.pop();
                        continue;
                    }
                    else if(st.peek() == val) {
                        st.pop();
                        destroyed = true;
                    }
                    destroyed = true;
                    break;
                }
                if(!destroyed) {
                    st.push(asteroids[i]);
                }
            }
        }
        int ans[] = new int[st.size()];
        for (int j = st.size() - 1; j >= 0; j--) {
            ans[j] = st.pop();
        }
        return ans;
    }
}