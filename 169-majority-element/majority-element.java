class Solution {
    public int majorityElement(int[] nums) {
        int ele = -1, cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(cnt == 0) {
                ele = nums[i];
                cnt++;
            }
            else if(nums[i] == ele) cnt++;
            else cnt--;
        }
        return ele;
    }
}