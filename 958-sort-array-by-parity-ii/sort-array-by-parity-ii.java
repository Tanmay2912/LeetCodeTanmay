class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        List<Integer> even = new LinkedList<>();
        List<Integer> odd = new LinkedList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 == 0) {
                even.add(nums[i]);
            }
            else {
                odd.add(nums[i]);
            }
        } 
        int e = 0;
        for(int i = 0; i < n; i += 2) {
            nums[i] = even.get(e);
            e++;
        }
        e = 0;
        for(int i = 1; i < n; i += 2) {
            nums[i] = odd.get(e);
            e++;
        }
        return nums;
    }
}