class Solution {
    public int helper(int[] nums, int k) {
        if(k < 0) return 0;
        int l = 0, r = 0, ans = 0, sum = 0;
        while(r < nums.length) {
            sum += (nums[r]%2);
            while(sum > k) {
                sum -= nums[l]%2;
                l++;
            }
            ans += r-l+1;
            r++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
}
