// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int low = 0, high = numbers.length - 1;
//         while (low < high) {
//             int sum = numbers[low] + numbers[high];
//             if (sum == target) {
//                 return new int[] {low + 1, high + 1}; 
//             } 
//             else if (sum < target) {
//                 low++;
//             } 
//             else {
//                 high--;
//             }
//         }
//         return new int[] {}; 
//     }
// }
// Done using two pointer approach
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[] {left+1, right+1};
            }
            else if(sum > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return new int[] {}; // returning empty array
    }
}