// class Solution {
//     public int gcd(int a, int b) {
//         return b == 0 ? a : gcd(b, a % b);
//     }
//     public int maxLength(int[] nums) {
//         int best = 2, left = 0, product = 1;
//         for (int right = 0; right < nums.length; right++) {
//             int x = nums[right];
//             while (gcd(product, x) > 1) {
//                 product /= nums[left++];
//             }    
//             product *= x;
//             best = Math.max(best, right - left + 1);
//         }
//         return best;
//     }
// }
class Solution {
    public int calcLCM(int a, int b) {
        return a * b / calcGCD(a, b);
    }
    public int calcGCD(int a, int b) {
        int rem = a % b;
        if (rem == 0) {
            return b;
        } else {
            return calcGCD(b, rem);
        }
    }
    public int maxLength(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int prod = nums[i];
            int gcd = nums[i];
            int lcm = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                gcd = calcGCD(gcd, nums[j]);
                lcm = calcLCM(lcm, nums[j]);
                prod *= nums[j];
                if (prod == gcd * lcm) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}