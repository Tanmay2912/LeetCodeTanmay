class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i = 0, j = 0, count = 0, ans = 0;
        int prefix = 0;
        while (j < nums.length) {
            if (nums[j] % 2 != 0) {
                count++;
                prefix = 0;
            }
            if (count == k) {
                while (i < j && nums[i] % 2 == 0) {
                    prefix++;
                    i++;
                }
                ans += (prefix + 1);
            }
            while (count > k) {
                if (nums[i] % 2 != 0) count--;
                i++;
                if (count == k) {
                    prefix = 0;
                    while (i < j && nums[i] % 2 == 0) {
                        prefix++;
                        i++;
                    }
                    ans += (prefix + 1);
                }
            }
            j++;
        }
        return ans;
    }
}
