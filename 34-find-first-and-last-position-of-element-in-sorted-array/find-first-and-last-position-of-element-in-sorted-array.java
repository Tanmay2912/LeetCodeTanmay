class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int ans[] = new int[2];
        Arrays.fill(ans, -1);
        // to find first position we will use lower bound
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] >= target) {
                if(nums[mid] == target) ans[0] = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        low = 0; 
        high = nums.length-1;
        // to find last occurence we will use upper bound
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] > target) {
                high = mid-1;
            }
            else {
                if(nums[mid] == target) {
                    ans[1] = mid;
                }
                low = mid+1;
            }
        }
        return ans;
    }
}