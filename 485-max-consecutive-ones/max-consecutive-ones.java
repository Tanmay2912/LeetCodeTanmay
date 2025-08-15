class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int maxcnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                maxcnt ++;
                ans = Math.max(ans, maxcnt);
            }
            else {    
                maxcnt = 0;
            }
        }
        return ans;
    }
}