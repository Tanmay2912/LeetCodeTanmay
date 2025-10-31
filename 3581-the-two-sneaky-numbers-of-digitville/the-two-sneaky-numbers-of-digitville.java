class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int result[] = new int[2];
        int i = 0;
        for(int key : nums) {
            if(st.contains(key)) {
                result[i] = key;
                i++;
            }
            st.add(key);
        }
        return result;
    }
}