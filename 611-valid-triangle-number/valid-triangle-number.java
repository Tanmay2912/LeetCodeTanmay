class Solution {
    // public boolean checkValid(int a, int b, int c) {
    //     if(a + b > c && b + c > a && a + c > b) {
    //         return true;
    //     }
    //     return false;
    // }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for(int i = nums.length-1; i >= 2; i--) {
            int l = 0, r = i-1;
            while(l < r) {
                if(nums[l] + nums[r] > nums[i]) {
                    cnt += (r-l);
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        return cnt;
    }
}