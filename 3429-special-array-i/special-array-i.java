class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        int slow = 0, fast = 1;
        while(slow < fast && fast < nums.length) {
            if((nums[slow]%2 != 0 && nums[fast]%2 != 0) || (nums[slow]%2 == 0 && nums[fast]%2 == 0)) {
                return false;
            }
            slow++;
            fast++;
        }
        return true;
    }
}