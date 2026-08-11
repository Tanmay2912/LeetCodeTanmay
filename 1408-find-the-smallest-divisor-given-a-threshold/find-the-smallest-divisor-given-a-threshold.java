class Solution {
    public int findDivisorSum(int[] nums, int d) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += (int) Math.ceil((double)nums[i]/d);
        }
        return sum;
    } 
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        int ans = 0;
        for(int num : nums) {
            high = Math.max(high, num);
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int sum = findDivisorSum(nums, mid);
            if(sum <= threshold) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
}















