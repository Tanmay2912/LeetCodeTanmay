class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        int ans[] = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        while(i <= j) {
            if(nums[i] > nums[j]) {
                ans[k] = nums[i];
                i++;
            } 
            else {
                ans[k] = nums[j];
                j--;
            }
            k--;
        }
        return ans;
    }
}