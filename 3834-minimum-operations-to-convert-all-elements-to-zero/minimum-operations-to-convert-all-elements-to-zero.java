/*class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        while (true) {
            boolean allZero = true;
            for (int num : nums) {
                if (num != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) break;  
            int i = 0;
            while (i < n) {
                while (i < n && nums[i] == 0) i++;
                if (i >= n) break;
                int j = i;
                while (j < n && nums[j] != 0) j++;
                int minVal = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    if (nums[k] != 0)
                        minVal = Math.min(minVal, nums[k]);
                }
                for (int k = i; k < j; k++) {
                    if (nums[k] == minVal)
                        nums[k] = 0;
                }
                operations++; 
                i = j; 
            }
        }
        return operations;
    }
}*/

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int size = 0;  
        int operations = 0;
        
        for (int num : nums) {
            if (num == 0) {
                operations += size;  
                size = 0;           
                continue;
            }
            
            while (size > 0 && stack[size - 1] > num) {
                size--;        
                operations++;
            }
            
            if (size == 0 || stack[size - 1] < num) {
                stack[size] = num;
                size++;
            }
        }
        
        operations += size; 
        return operations;
    }
}