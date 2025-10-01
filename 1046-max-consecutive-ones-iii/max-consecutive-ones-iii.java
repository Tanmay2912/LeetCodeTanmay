/*class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            int zero = 0;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] == 0) {
                    zero++;
                }
                if(zero <= k) {
                    int len = j-i+1;
                    maxLen = Math.max(maxLen, len);
                }
                else {
                    break;
                }
            }
        }
        return maxLen;
    }
}*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int maxLen = 0, zero = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                zero++;
            }
            while (zero > k) {
                if (nums[l] == 0) zero--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
