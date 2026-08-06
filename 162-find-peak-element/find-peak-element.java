class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = (low+high)/2;
            boolean leftOk = (mid == 0) || (nums[mid] > nums[mid-1]);
            boolean rightOk = (mid == nums.length-1) || (nums[mid] > nums[mid+1]);
            if(leftOk && rightOk) return mid;
            if(mid < nums.length-1 && nums[mid] < nums[mid+1]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}