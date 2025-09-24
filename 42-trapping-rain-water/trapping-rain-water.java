// class Solution {
//     public int[] prefixMax(int[] height) {
//         int[] prefix = new int[height.length];
//         prefix[0] = height[0];
//         for(int i = 1; i < height.length-1; i++) {
//             prefix[i] = Math.max(prefix[i-1], height[i]);
//         }
//         for(int i = 0; i < prefix.height; i++) {
//             System.out.print(prefix[i] + " ");
//         }
//         return prefix;
//     }
//     public int[] suffixMax(int[] height) {
//         int suffix[] = new int[height.length];
//         suffix[height.length-1] = height[height.length-1];
//         for(int i = height.length-2; i >= 0; i--) {
//             suffix[i] = Math.max(suffix[i+1], height[i]);
//         }
//         return suffix;
//     }
//     public int trap(int[] height) {
//         int prefix[] = prefixMax(height);
//         int suffix[] = suffixMax(height);
//         int total = 0;
//         for(int i = 0; i < height.length; i++) {
//             if(height[i] < prefix[i] && height[i] < suffix[i]) {
//                 total += (Math.min(prefix[i], suffix[i]) - height[i]);
//             }
//         }
//         return total;
//     }
// }

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int lMax = 0, rMax = 0;
        int total = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] > lMax) {
                    lMax = height[left];
                }
                else {
                    total += lMax - height[left];
                } 
                left++;
            }
            else {
                if(height[right] >= rMax) {
                    rMax = height[right];
                }
                else {
                    total += rMax - height[right];
                }
                right--;
            }
        }
        return total;
    }
}