class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int k = nums.length-3;
        while(k >= 0) {
            if(nums[k]+nums[k+1] > nums[k+2]) {
                return nums[k]+nums[k+1]+nums[k+2];
            }
            k--;
        }
        return 0;
    }
}