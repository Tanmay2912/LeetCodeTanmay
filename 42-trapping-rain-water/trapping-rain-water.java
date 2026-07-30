// class Solution {
//     public int trap(int[] height) {
//         int left = 0, right = height.length-1;
//         int lMax = 0, rMax = 0;
//         int total = 0;
//         while(left < right) {
//             if(height[left] < height[right]) {
//                 if(height[left] > lMax) {
//                     lMax = height[left];
//                 }
//                 else {
//                     total += lMax - height[left];
//                 } 
//                 left++;
//             }
//             else {
//                 if(height[right] >= rMax) {
//                     rMax = height[right];
//                 }
//                 else {
//                     total += rMax - height[right];
//                 }
//                 right--;
//             }
//         }
//         return total;
//     }
// }
// brute force approach 
// here we will use prefixMax and suffixMax of the array
// use formula (min(leftMax, rightMax)-height[i])
class Solution {
    public void prefixMax(int[] height, int[] preMax) {
        preMax[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            preMax[i] = Math.max(preMax[i-1], height[i]);
        }
    } 
    public void suffixMax(int[] height, int[] sufMax) {
        sufMax[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i+1], height[i]);
        }
    }
    public int trap(int[] height) {
        int ans = 0;
        int preMax[] = new int[height.length];
        int sufMax[] = new int[height.length];
        prefixMax(height, preMax);
        suffixMax(height, sufMax);
        for(int i = 0; i < height.length; i++) {
            ans += (Math.min(preMax[i], sufMax[i]))-height[i];
        }
        return ans;
    }
}