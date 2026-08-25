class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]%k == 0) {
                set.add(nums[i]);
            }
        }
        int ans = 0;
        for(int i = 1; i <= 101; i++) {
            ans = k*i;
            if(!set.contains(ans)) {
                return ans;
            } 
        }
        return -1;
    }
} 
