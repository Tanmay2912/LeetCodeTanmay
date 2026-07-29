// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int ans = 0;
//         int maxcnt = 0;
//         for(int i = 0; i < nums.length; i++) {
//             if(nums[i] == 1) {
//                 maxcnt ++;
//                 ans = Math.max(ans, maxcnt);
//             }
//             else {    
//                 maxcnt = 0;
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int low = 0, high = 0, ans = 0;
        while(high < nums.length) {
            if(nums[high] == 0) {
                low = high + 1;
            }
            ans = Math.max(ans, high-low+1);
            high++;
        }
        return ans;
    }
}