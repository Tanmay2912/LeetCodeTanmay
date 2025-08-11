class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
        // int low = 0, high = nums.length - 1;
        // int ans = -1;
        // while(low <= high) {
        //     int mid = (low + high) / 2;
        //     ans = Math.min (nums[mid], ans);
        //     if(nums[low] <= nums[mid]) {
        //         high = mid - 1;
        //     }

        // }
    }
}