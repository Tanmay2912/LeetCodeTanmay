class Solution {
    public int findMaxArray(int[] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
    public int findSumArray(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
    public int findCountPart(int[] nums, int mid) {
        int count = 1, sumArr = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sumArr + nums[i] <= mid) {
                sumArr += nums[i];
            }
            else {
                count ++;
                sumArr = nums[i];
            }
        }
        return count;  
    }
    public int splitArray(int[] nums, int k) {
        int low = findMaxArray(nums);
        int high = findSumArray(nums);
        int ans = high;
        while(low <= high) {
            int mid = (low + high)/2;
            int countPart = findCountPart(nums, mid);
            if(countPart <= k) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}